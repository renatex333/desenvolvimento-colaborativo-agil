
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http.exception;

import jakarta.servlet.http.HttpServletResponse;

public class BadRequestException extends ServerException {
	private static final long serialVersionUID = 8035741632255226717L;

	public BadRequestException(String message) {
		super(HttpServletResponse.SC_BAD_REQUEST, message);
	}
}
