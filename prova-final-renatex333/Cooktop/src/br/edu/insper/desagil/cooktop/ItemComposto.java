package br.edu.insper.desagil.cooktop;

import java.util.List;

public class ItemComposto extends ItemGenerico{
	private List<Item> itens;

	public ItemComposto(List<Item> itens, String codigo, String nome) {
		super(codigo, nome);
		this.itens = itens;
	}

	public List<Item> getItens() {
		return itens;
	}
}
