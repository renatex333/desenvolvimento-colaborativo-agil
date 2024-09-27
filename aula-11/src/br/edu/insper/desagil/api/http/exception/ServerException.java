
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public abstract class ServerException extends InternalException {
	private static final long serialVersionUID = -2284373733374415063L;

	private final int status;

	public ServerException(int status, String message) {
		super(message);
		this.status = status;
	}

	public final int getStatus() {
		return status;
	}
}
