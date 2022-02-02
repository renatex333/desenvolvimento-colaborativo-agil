
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api;

import java.net.InetAddress;

import org.eclipse.jetty.server.Server;

import br.edu.insper.desagil.api.http.Handler;

public final class API {
	private static final int PORT = 8080;

	public static final void main(String[] args) throws Exception {
		Handler handler = new Handler();

		Server server = new Server(PORT);
		server.setHandler(handler);
		server.start();

		String address = InetAddress.getLocalHost().getHostAddress();

		System.out.println("Waiting on http://" + address + ':' + PORT);
	}
}
