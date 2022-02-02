
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

import jakarta.servlet.http.HttpServletResponse;

public class NotFoundException extends ServerException {
	private static final long serialVersionUID = 3147586153425381355L;

	public NotFoundException(String message) {
		super(HttpServletResponse.SC_NOT_FOUND, message);
	}
}
