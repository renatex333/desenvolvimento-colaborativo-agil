
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http;

import java.util.HashMap;

import br.edu.insper.desagil.api.http.exception.InternalException;

public final class Result extends HashMap<String, Object> {
	private static final long serialVersionUID = 3801845786710561283L;

	@Override
	public final Object put(String name, Object value) {
		if (name.isBlank()) {
			throw new InternalException("Blank results not allowed");
		}
		return super.put(name, value);
	}
}
