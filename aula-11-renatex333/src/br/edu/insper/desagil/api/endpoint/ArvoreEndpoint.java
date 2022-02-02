package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class ArvoreEndpoint extends Endpoint<String> {
	public ArvoreEndpoint() {
		super("/arvore");
	}

	@Override
	public String get(Args args) {
		int n = args.getInt("n");
		String arvore = "";
		for (int i = 0; i < n; i++) {
			String linha = "";
			for (int j = 0; j < n - i - 1; j++) {
				linha += " ";
			}
			for (int j = 0; j < i; j++) {
				linha += "/";
			}
			linha += "|";
			for (int j = 0; j < i; j++) {
				linha += "\\";
			}
			arvore += linha + "\n";
		}
		return arvore;
	}

}

