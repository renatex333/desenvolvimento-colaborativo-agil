package br.edu.insper.desagil.checkout;

public class Pedido {
	private Produto produto;
	private int quantidade;
	
	public Pedido(Produto produto) {
		this.produto = produto;
		this.quantidade = 1;
	}
	
	public Produto getProduto() {
		return this.produto;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void incrementa() {
		this.quantidade++;
	}
	
	public void decrementa() {
		this.quantidade--;
	}
	
	public double calculaTotal() {
		return this.quantidade * this.produto.getPreco();
	}
}
