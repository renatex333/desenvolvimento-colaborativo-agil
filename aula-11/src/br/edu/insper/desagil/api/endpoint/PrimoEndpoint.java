package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class PrimoEndpoint extends Endpoint<Integer> {
	public PrimoEndpoint() {
		super("/primo");
	}

	@Override
	public Integer get(Args args) {
		int limite = args.getInt("limite");
		int primos = 0;
		if (limite == 2) {
			primos++;
		} else {
			for (int n = limite; n >= 2; n--) {
				for (int i = 2; i <= n; i++) {
					if (n % i != 0) {
						;
					} else {
						if (n == i) {
							primos++;
						} else {
							break;
						}
					}
				}
			}
		}	
		return primos;
	}

}

