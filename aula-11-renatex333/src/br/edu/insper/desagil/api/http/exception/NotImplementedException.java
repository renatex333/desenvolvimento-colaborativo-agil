
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public class NotImplementedException extends NotAllowedException {
	private static final long serialVersionUID = 2636897191586395943L;

	public NotImplementedException(String method) {
		super(method, "not implemented");
	}
}
