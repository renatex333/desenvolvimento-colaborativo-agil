package br.edu.insper.desagil.banco;

import java.util.Date;

public abstract class Cartao {
	private String numero;
	private Date vencimento;
	private int codigo;

	public Cartao(String numero, Date vencimento, int codigo) {
		this.numero = numero;
		this.vencimento = vencimento;
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public int getCodigo() {
		return codigo;
	}
}
