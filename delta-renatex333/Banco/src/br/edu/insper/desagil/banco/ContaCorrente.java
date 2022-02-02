package br.edu.insper.desagil.banco;

import java.util.List;

public class ContaCorrente extends Conta {
	private List<Cartao> cartoes;

	public ContaCorrente(String agencia, String numero, double saldo, List<Cartao> cartoes) {
		super(agencia, numero, saldo);
		this.cartoes = cartoes;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}
}
