package br.edu.insper.desagil.aquecimento;

public class Primo {

	public int conta(int limite) {
		int total = 0;
		
		for (int n = 2; n <= limite; n++) {
			if (!temDivisor(n)) {
				total ++;
			}
		}
		return total;
	}

	public boolean temDivisor(int n) {
		for (int d = 2; d < n; d++) {
			if (n % d == 0) {
				return true;
			}
		}
		return false;
	}

}
