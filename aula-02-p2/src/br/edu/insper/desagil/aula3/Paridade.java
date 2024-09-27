package br.edu.insper.desagil.aula3;

import java.util.ArrayList;
import java.util.List;

public class Paridade {

	public List<List<Integer>> separa(List<Integer> numeros) {
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();

		for (Integer n: numeros) {
			if (n % 2 == 0) {
				pares.add(n);
			} else {
				impares.add(n);
			}
		}

		List<List<Integer>> listas = new ArrayList<>();
		listas.add(pares);
		listas.add(impares);
		return listas;
	}

}
