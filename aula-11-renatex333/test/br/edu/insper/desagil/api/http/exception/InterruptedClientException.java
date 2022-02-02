
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public class InterruptedClientException extends ClientException {
	private static final long serialVersionUID = 3868825159616942970L;

	public InterruptedClientException(InterruptedException exception) {
		super("Client execution interrupted", exception);
	}
}
