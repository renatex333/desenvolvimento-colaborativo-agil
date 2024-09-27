package br.edu.insper.desagil.cooktop;

public class Item extends ItemGenerico{
	private int quantidade;

	public Item(String codigo, String nome, int quantidade) {
		super(codigo, nome);
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
