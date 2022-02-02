
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public class InternalException extends RuntimeException {
	private static final long serialVersionUID = 7482372860461620712L;

	public InternalException(String message) {
		super(message);
	}
}
