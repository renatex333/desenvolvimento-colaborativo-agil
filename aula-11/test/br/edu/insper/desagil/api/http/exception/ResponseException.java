// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public final class ResponseException extends InternalException {
	private static final long serialVersionUID = -3816746222582978254L;

	public ResponseException(int status, String message) {
		super(Integer.toString(status) + ": " + message);
	}
}