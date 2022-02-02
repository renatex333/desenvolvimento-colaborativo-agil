package br.edu.insper.desagil.banco;

public class ContaPoupanca extends Conta {
	private CartaoDeDebito cartao;

	public ContaPoupanca(String agencia, String numero, double saldo, CartaoDeDebito cartao) {
		super(agencia, numero, saldo);
		this.cartao = cartao;
	}

	public CartaoDeDebito getCartao() {
		return cartao;
	}
}
