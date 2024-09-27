
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

import java.util.concurrent.ExecutionException;

public class ExecutionClientException extends ClientException {
	private static final long serialVersionUID = 8690472671812943799L;

	public ExecutionClientException(ExecutionException exception) {
		super("Client execution failed", exception);
	}
}
