
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public abstract class ClientException extends InternalException {
	private static final long serialVersionUID = 3992588051876984040L;

	public ClientException(String prefix, Exception exception) {
		super(prefix + ": " + exception.getMessage());
	}
}
