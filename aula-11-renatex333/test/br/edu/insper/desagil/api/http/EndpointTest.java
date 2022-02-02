
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringRequestContent;

import com.google.gson.Gson;

import br.edu.insper.desagil.api.http.exception.ExecutionClientException;
import br.edu.insper.desagil.api.http.exception.InternalException;
import br.edu.insper.desagil.api.http.exception.InterruptedClientException;
import br.edu.insper.desagil.api.http.exception.ResponseException;
import br.edu.insper.desagil.api.http.exception.TimeoutClientException;

public abstract class EndpointTest<T> {
	private int timeout;
	private String baseUrl;
	private Type type;
	private Gson gson;
	private HttpClient client;

	protected final void start(String baseUrl, int timeout) {
		this.timeout = timeout;
		this.baseUrl = baseUrl;

		ParameterizedType genericType = (ParameterizedType) getClass().getGenericSuperclass();
		Type[] types = genericType.getActualTypeArguments();
		this.type = types[0];

		this.gson = new Gson();
		this.client = new HttpClient();

		try {
			this.client.start();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	protected final void start(String baseUrl) {
		start(baseUrl, 10);
	}

	private String encode(String subItem) {
		return URLEncoder.encode(subItem, StandardCharsets.UTF_8);
	}

	private Request request(String method, String args, boolean isList) {
		if (!args.startsWith("?")) {
			throw new InternalException("Args must start with a question mark");
		}
		String[] items = args.substring(1).split("&");
		for (int i = 0; i < items.length; i++) {
			String[] subItems = items[i].split("=");
			if (subItems.length < 2) {
				throw new InternalException("Arg must have a key and a value separated by an equals sign");
			}
			if (subItems.length > 2) {
				throw new InternalException("Arg must have only one equals sign");
			}
			items[i] = encode(subItems[0]) + "=" + encode(subItems[1]);
		}
		args = "?" + String.join("&", items);
		String url;
		if (isList) {
			url = baseUrl + "/list" + args;
		} else {
			url = baseUrl + args;
		}
		Request request;
		try {
			request = client.newRequest(url);
		} catch (IllegalArgumentException exception) {
			throw new InternalException("URL could not be resolved");
		}
		return request.method(method).timeout(timeout, TimeUnit.SECONDS);
	}

	private String send(Request request) {
		ContentResponse response;
		try {
			response = request.send();
		} catch(TimeoutException exception) {
			throw new TimeoutClientException(exception);
		} catch(ExecutionException exception) {
			throw new ExecutionClientException(exception);
		} catch(InterruptedException exception) {
			throw new InterruptedClientException(exception);
		}
		int status = response.getStatus();
		String responseBody = response.getContentAsString();
		if (status != 200) {
			throw new ResponseException(status, responseBody);
		}
		return responseBody;
	}

	private String sendRequest(String method, String args, boolean isList) {
		return send(request(method, args, isList));
	}

	private Result sendRequest(String method, String args, T body) {
		String requestBody = gson.toJson(body);
		StringRequestContent content = new StringRequestContent(requestBody);
		String responseBody = send(request(method, args, false).body(content));
		return gson.fromJson(responseBody, Result.class);
	}

	private String doGet(String args, boolean isList) {
		return sendRequest("get", args, isList);
	}

	private Result doDelete(String args, boolean isList) {
		String responseBody = sendRequest("delete", args, isList);
		return gson.fromJson(responseBody, Result.class);
	}

	@SuppressWarnings("unchecked")
	protected final T get(String args) {
		String responseBody = doGet(args, false);
		if (type.toString().equals("class java.lang.String")) {
			return (T) responseBody.substring(0, responseBody.length() - 1);
		} else {
			return gson.fromJson(responseBody, type);
		}
	}

	protected final List<T> getList(String args) {
		return gson.fromJson(doGet(args, true), type);
	}

	protected final Result post(String args, T body) {
		return sendRequest("post", args, body);
	}

	protected final Result put(String args, T body) {
		return sendRequest("put", args, body);
	}

	protected final Result delete(String args) {
		return doDelete(args, false);
	}

	protected final Result deleteList(String args) {
		return doDelete(args, true);
	}

	protected final void stop() {
		try {
			client.stop();
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}
}