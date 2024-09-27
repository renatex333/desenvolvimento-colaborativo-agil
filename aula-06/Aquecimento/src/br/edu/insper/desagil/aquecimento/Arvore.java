package br.edu.insper.desagil.aquecimento;

public class Arvore {

	public String constroi(int n) {
		String arvore = "";
		for (int i = 0; i < n; i++) {
			int j;
			for (j = 0; j < n - 1 - i; j++) {
				arvore += " ";
			}
			for (j = 0; j < i; j++) {
				arvore += "/";
			}
			arvore += "|";
			for (j = 0; j < i; j++) {
				arvore += "\\";
			}
			arvore += "\n";
		}
		return arvore;
	}

}
