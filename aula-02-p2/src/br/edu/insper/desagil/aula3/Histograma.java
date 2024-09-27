package br.edu.insper.desagil.aula3;

import java.util.ArrayList;
import java.util.List;

public class Histograma {

	public List<Integer> calcula(List<Integer> numeros) {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i <= 9; i++) {
			int soma = 0;
			for (Integer n: numeros) {
				if (n == i) {
					soma++;
				}
			}
			l.add(soma);
		}
		return l;
	}

}
