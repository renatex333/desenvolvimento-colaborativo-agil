package br.edu.insper.desagil.aula2;

public class Arvore {

	public String constroi(int n) {
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