
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

import jakarta.servlet.http.HttpServletResponse;

public abstract class NotAllowedException extends ServerException {
	private static final long serialVersionUID = -3909145847085017247L;

	public NotAllowedException(String method, String suffix) {
		super(HttpServletResponse.SC_METHOD_NOT_ALLOWED, method.toUpperCase() + " " + suffix);
	}
}
