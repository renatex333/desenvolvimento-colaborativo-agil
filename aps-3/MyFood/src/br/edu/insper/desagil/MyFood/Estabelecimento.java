package br.edu.insper.desagil.MyFood;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estabelecimento {
	private String nome;
	private Map<Integer, Item> itens;	
	
	public Estabelecimento(String nome) {
		this.nome = nome;
		this.itens = new HashMap<Integer, Item>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void cadastra(int codigo, Item item) {
			this.itens.put(codigo, item);
	}
	
	public double processa(List<Integer> codigos) {
		double soma = 0;
		for(int codigo: codigos) {
			if (this.itens.containsKey(codigo)) {
				soma += this.itens.get(codigo).getPreco();
			}
						
		}
		return soma;
	}
	
}
