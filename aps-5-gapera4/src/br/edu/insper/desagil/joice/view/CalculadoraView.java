package br.edu.insper.desagil.joice.view;

import br.edu.insper.desagil.joice.model.Calculadora;

public abstract class CalculadoraView {
	private Calculadora calculadora;
	private String nomeImagem;

	public CalculadoraView(Calculadora calculadora, String nomeImagem) {
		this.calculadora = calculadora;
		this.nomeImagem = nomeImagem;
	}

	public Calculadora getCalculadora() {
		return this.calculadora;
	}

	public String getNomeImagem() {
		return this.nomeImagem;
	}

	public String toString() {
		return this.calculadora.getNome();
	}
}
