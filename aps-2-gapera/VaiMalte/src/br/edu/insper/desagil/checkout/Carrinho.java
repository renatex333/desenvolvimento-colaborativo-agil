package br.edu.insper.desagil.checkout;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	private List<Pedido> pedidos;
	
	public Carrinho() {
		this.pedidos = new ArrayList<>();
	}
	
	
	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void insere(Produto produto) {
		int codigo = produto.getCodigo();
		
		for (Pedido pedido: this.pedidos) {
			if (pedido.getProduto().getCodigo() == codigo) {
				pedido.incrementa();
			} else {
				Pedido novoPedido = new Pedido(produto);
				this.pedidos.add(novoPedido);
			}
		}
	}
	
	public void remove(int codigo) {
		for (Pedido pedido: this.pedidos) {
			if (pedido.getProduto().getCodigo() == codigo && pedido.getQuantidade() > 1){
				pedido.decrementa();
			} else if (pedido.getProduto().getCodigo() == codigo && pedido.getQuantidade() == 1) {
				int i = this.pedidos.indexOf(pedido);
				this.pedidos.remove(i);
			}
		}
	}
}
