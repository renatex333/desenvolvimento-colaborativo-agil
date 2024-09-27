package br.edu.insper.desagil.aula2;

public class Primo {

	public int conta(int limite) {
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
