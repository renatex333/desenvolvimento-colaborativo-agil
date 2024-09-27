package br.edu.insper.desagil.api.endpoint;

import java.util.ArrayList;
import java.util.List;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class HistogramaEndpoint extends Endpoint<List<Integer>> {
	public HistogramaEndpoint() {
		super("/histograma");
	}

	@Override
	public List<Integer> get(Args args) {
		List<Integer> numeros = args.getListInt("numeros", ",");
		List<Integer> h = new ArrayList<>();
		for (int i = 0; i <= 9; i++) {
			int soma = 0;
			for (Integer n: numeros) {
				if (n == i) {
					soma++;
				}
			}
			h.add(soma);
		}
		return h;
	}

}