
// NÃO É NECESSÁRIO ENTENDER NEM MODIFICAR ESTA CLASSE

package br.edu.insper.desagil.api.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.edu.insper.desagil.api.http.exception.InternalException;

public final class Args extends HashMap<String, String> {
	private static final long serialVersionUID = -4614210952776098197L;

	private static final List<String> split(String value, String regex) {
		return Arrays.asList(value.split(regex));
	}

	public final String get(String name) {
		String value = super.get(name);
		if (value == null) {
			throw new InternalException("Arg " + name + " not found");
		}
		return value;
	}

	public final boolean getBoolean(String name) {
		return Boolean.parseBoolean(get(name));
	}

	public final int getInt(String name) {
		try {
			return Integer.parseInt(get(name));
		} catch(NumberFormatException exception) {
			throw new InternalException("Arg " + name + " cannot be converted to int");
		}
	}

	public final double getDouble(String name) {
		try {
			return Double.parseDouble(get(name));
		} catch(NumberFormatException exception) {
			throw new InternalException("Arg " + name + " cannot be converted to double");
		}
	}

	public final List<String> getList(String name, String regex) {
		return Args.split(get(name), regex);
	}

	public final List<Boolean> getListBoolean(String name, String regex) {
		List<Boolean> values = new ArrayList<>();
		for (String value: getList(name, regex)) {
			values.add(Boolean.parseBoolean(value));
		}
		return values;
	}

	public final List<Integer> getListInt(String name, String regex) {
		List<Integer> values = new ArrayList<>();
		for (String value: getList(name, regex)) {
			try {
				values.add(Integer.parseInt(value));
			} catch(NumberFormatException exception) {
				throw new InternalException("Arg " + name + " cannot be converted to list of ints");
			}
		}
		return values;
	}

	public final List<Double> getListDouble(String name, String regex) {
		List<Double> values = new ArrayList<>();
		for (String value: getList(name, regex)) {
			try {
				values.add(Double.parseDouble(value));
			} catch(NumberFormatException exception) {
				throw new InternalException("Arg " + name + " cannot be converted to list of doubles");
			}
		}
		return values;
	}
}
