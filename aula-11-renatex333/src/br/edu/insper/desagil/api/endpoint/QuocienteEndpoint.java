package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class QuocienteEndpoint extends Endpoint<Double> {
	public QuocienteEndpoint() {
		super("/quociente");
	}

	@Override
	public Double get(Args args) {
		double a = args.getDouble("a");
		double b = args.getDouble("b");
		return a / b;
	}
}
