package br.edu.insper.desagil.cooktop;

import java.util.List;

public class Receita {
	private List<Object> ingredientes;

	public Receita(List<Object> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public void retira() {
		for (Object ingrediente : ingredientes) {
			if (ingrediente instanceof Item) {
				Item item = (Item) ingrediente;
				int novaQuantidade = item.getQuantidade() - 1;
				item.setQuantidade(novaQuantidade);
			} else {
				ItemComposto itemComposto = (ItemComposto) ingrediente;
				for (Item item : itemComposto.getItens()) {
					int novaQuantidade = item.getQuantidade() - 1;
					item.setQuantidade(novaQuantidade);
				}
			}
		}
	}
}
