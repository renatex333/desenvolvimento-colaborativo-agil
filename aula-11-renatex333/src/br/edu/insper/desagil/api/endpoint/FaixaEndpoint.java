package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class FaixaEndpoint extends Endpoint<String>{
	public FaixaEndpoint() {
		super("/faixa");
	}
	
	@Override
	public String get(Args args) {
		int idade = args.getInt("idade");
		if (idade < 18) {
			return "Jovem";
		} else if (idade >= 18 && idade < 60) {
			return "Adulto";
		} else {
			return "Idoso";
		}
	}
}
