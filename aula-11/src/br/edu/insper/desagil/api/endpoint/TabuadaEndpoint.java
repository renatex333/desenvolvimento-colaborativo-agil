package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class TabuadaEndpoint extends Endpoint<String> {
	public TabuadaEndpoint() {
		super("/tabuada");
	}

	@Override
	public String get(Args args) {
		int n = args.getInt("n");
		String tabuada = "";
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int v = i*j;
				String s = Integer.toString(v);
				tabuada += s;
				tabuada += " ";
			}
			tabuada += "\n";
		}
		return tabuada;
	}

}
