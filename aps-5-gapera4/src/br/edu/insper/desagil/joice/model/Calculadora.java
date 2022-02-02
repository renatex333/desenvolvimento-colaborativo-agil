package br.edu.insper.desagil.joice.model;

public abstract class Calculadora {
	private String nome;

	public Calculadora(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public abstract double calcula(double peso, double raio);
}
