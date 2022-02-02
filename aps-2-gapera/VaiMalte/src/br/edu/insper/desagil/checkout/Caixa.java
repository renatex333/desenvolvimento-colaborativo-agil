package br.edu.insper.desagil.checkout;

import java.util.HashMap;
import java.util.Map;

public class Caixa {
	private Map<Produto, Integer> descontos;

	public Caixa() {
		
		this.descontos = new HashMap<>();
	}
	public void adicionaDesconto(Produto produto,int n) {
		if(n>=1 && n<=99) {
			this.descontos.put(produto,n);
		}
	}
	public double calculaTotal(Carrinho carrinho) {
		int total=0;
		
		for (Pedido pedido:carrinho.getPedidos()) {
			total+=pedido.calculaTotal()*(1-descontos.get(pedido.getProduto()))/100;
			
		}return total;
	}
	
}
