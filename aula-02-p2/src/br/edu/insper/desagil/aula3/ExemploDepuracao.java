package br.edu.insper.desagil.aula3;

import java.util.List;

public class ExemploDepuracao {


	public double exemploErrado(List<Integer> valores, int maximo) {
		double soma = 0.0;

		for (int i = 0; i < valores.size(); i++) {
			int valor = valores.get(i);

			double porcentagem = (valor / maximo) * 100;

			soma += porcentagem;
		}

		return soma / valores.size();
	}


	public double exemploCerto(List<Integer> valores, int maximo) {
		double soma = 0.0;

		for (int i = 0; i < valores.size(); i++) {
			int valor = valores.get(i);

			double porcentagem = ((double) valor / maximo) * 100;

			soma += porcentagem;
		}

		return soma / valores.size();
	}


	public double exemploReescrito(List<Integer> valores, int maximo) {
		double soma = 0.0;

		for (int valor: valores) {
			soma += ((double) valor / maximo) * 100;
		}

		return soma / valores.size();
	}


}
