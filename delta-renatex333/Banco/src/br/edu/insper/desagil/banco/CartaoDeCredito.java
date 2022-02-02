package br.edu.insper.desagil.banco;

import java.util.Date;

public class CartaoDeCredito extends Cartao {
	public CartaoDeCredito(String numero, Date vencimento, int codigo) {
		super(numero, vencimento, codigo);
	}
}
