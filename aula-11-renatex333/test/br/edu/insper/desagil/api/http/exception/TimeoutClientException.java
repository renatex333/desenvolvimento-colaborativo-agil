
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

import java.util.concurrent.TimeoutException;

public class TimeoutClientException extends ClientException {
	private static final long serialVersionUID = 3918910346303076679L;

	public TimeoutClientException(TimeoutException exception) {
		super("Client timed out", exception);
	}
}
