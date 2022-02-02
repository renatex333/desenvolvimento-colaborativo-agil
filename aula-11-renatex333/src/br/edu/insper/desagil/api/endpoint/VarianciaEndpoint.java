package br.edu.insper.desagil.api.endpoint;

import java.util.List;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class VarianciaEndpoint extends Endpoint<Double> {
	public VarianciaEndpoint() {
		super("/variancia");
	}

	@Override
	public Double get(Args args) {
		List<Integer> numeros = args.getListInt("numeros", ",");
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
