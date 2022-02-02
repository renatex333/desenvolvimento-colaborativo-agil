
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

public class NotSupportedException extends NotAllowedException {
	private static final long serialVersionUID = 1547739806858507311L;

	public NotSupportedException(String method) {
		super(method, "not supported");
	}
}
