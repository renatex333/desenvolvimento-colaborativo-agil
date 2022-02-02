package br.edu.insper.desagil.aula2;

import java.util.ArrayList;
import java.util.List;

public class Paridade {

	public List<List<Integer>> separa(List<Integer> numeros) {
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();

		// seu código aqui

		List<List<Integer>> listas = new ArrayList<>();
		listas.add(pares);
		listas.add(impares);
		return listas;
	}

}
