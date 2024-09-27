package br.edu.insper.desagil.banco;

import java.util.Date;

public class CartaoDeDebito extends Cartao {
	public CartaoDeDebito(String numero, Date vencimento, int codigo) {
		super(numero, vencimento, codigo);
	}
}
