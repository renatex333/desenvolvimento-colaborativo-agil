package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class BissextoEndpoint extends Endpoint<String>{
	public BissextoEndpoint() {
		super("/bissexto");
	}
	
	@Override
	public String get(Args args) {
		int ano = args.getInt("ano");
		if (ano % 4 == 0) {
			return "É bissexto";
		} else {
			return "Não é bissexto";
		}
		
	}
}

