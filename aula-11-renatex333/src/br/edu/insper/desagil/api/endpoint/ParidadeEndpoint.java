package br.edu.insper.desagil.api.endpoint;

import java.util.ArrayList;
import java.util.List;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class ParidadeEndpoint extends Endpoint<List<List<Integer>>> {
	public ParidadeEndpoint() {
		super("/paridade");
	}

	@Override
	public List<List<Integer>> get(Args args) {
		List<Integer> numeros = args.getListInt("numeros", ",");
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();

		for (Integer n: numeros) {
			if (n % 2 == 0) {
				pares.add(n);
			} else {
				impares.add(n);
			}
		}

		List<List<Integer>> listas = new ArrayList<>();
		listas.add(pares);
		listas.add(impares);
		return listas;
	}

}