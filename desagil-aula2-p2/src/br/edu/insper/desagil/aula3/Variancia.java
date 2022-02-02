package br.edu.insper.desagil.aula3;

import java.util.List;

public class Variancia {

	public double calcula(List<Integer> numeros) {
		int soma = 0;
		for (Integer n: numeros) {
			soma += n;
		}
		int tamanho = numeros.size();
		double media = (double) soma / tamanho;
		double variancia = 0.0;
		for (Integer n: numeros) {
			double elemento = n - media;
			variancia += elemento*elemento;
		}
		variancia = variancia / tamanho;
		return variancia;
	}

}
