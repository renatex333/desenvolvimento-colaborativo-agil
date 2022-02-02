package br.edu.insper.desagil.aquecimento;

public class Tabuada {

	public String constroi(int n) {
		String tabuada = "";
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				tabuada += (i * j) + " ";
			}
			tabuada += "\n";
		}
		return tabuada;
	}

}
