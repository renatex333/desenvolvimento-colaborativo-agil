package br.edu.insper.desagil.banco;

public abstract class Conta {
	String agencia;
	String numero;
	double saldo;

	public Conta(String agencia, String numero, double saldo) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
	}

	public String getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void saca(double quantia) {
		saldo -= quantia;
	}

	public void deposita(double quantia) {
		saldo += quantia;
	}
}
