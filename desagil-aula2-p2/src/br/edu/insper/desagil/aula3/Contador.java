package br.edu.insper.desagil.aula3;

import java.util.HashMap;
import java.util.Map;

public class Contador {

	public Map<Character, Integer> calcula(String palavra) {
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
