package br.edu.insper.desagil.api.endpoint;

import java.util.HashMap;
import java.util.Map;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class ContadorEndpoint extends Endpoint<Map<Character, Integer>> {
	public ContadorEndpoint() {
		super("/contador");
	}

	@Override
	public Map<Character, Integer> get(Args args) {
		String palavra = args.get("p");
		Map<Character, Integer> d = new HashMap<>();
		for (int i = 0; i < palavra.length(); i++) {
			char c = palavra.charAt(i);
			if (d.containsKey(c)) {
				d.put(c, d.get(c)+1);
			} else {
				d.put(c, 1);
			}
		}

		return d;
	}

}