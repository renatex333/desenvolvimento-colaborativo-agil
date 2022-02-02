package br.edu.insper.desagil.api.endpoint;

import java.util.List;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class SomatoriaEndpoint extends Endpoint<Integer> {
	public SomatoriaEndpoint() {
		super("/somatoria");
	}

	@Override
	public Integer get(Args args) {
		List<Integer> l = args.getListInt("l", ",");
		int s = 0;
		for (int i: l) {
			s += i;
		}
		return s;
	}
}
