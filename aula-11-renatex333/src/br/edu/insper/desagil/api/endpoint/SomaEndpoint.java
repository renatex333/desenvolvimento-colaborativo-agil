package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class SomaEndpoint extends Endpoint<Integer> {
	public SomaEndpoint() {
		super("/soma");
	}

	@Override
	public Integer get(Args args) {
		int a = args.getInt("a");
		int b = args.getInt("b");
		return a + b;
	}
}
