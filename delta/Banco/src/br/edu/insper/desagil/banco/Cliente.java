package br.edu.insper.desagil.banco;

import java.util.List;

public class Cliente {
	private String cpf;
	private String nome;
	private List<Conta> contas;

	public Cliente(String cpf, String nome, List<Conta> contas) {
		this.cpf = cpf;
		this.nome = nome;
		this.contas = contas;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public double saldoTotal() {
		double s = 0;
		for (Conta conta : contas) {
			s += conta.getSaldo();
		}
		return s;
	}
}
