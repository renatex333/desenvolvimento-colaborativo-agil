package br.edu.insper.desagil.aula2;

public class Tabuada {

	public String constroi(int n) {
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
