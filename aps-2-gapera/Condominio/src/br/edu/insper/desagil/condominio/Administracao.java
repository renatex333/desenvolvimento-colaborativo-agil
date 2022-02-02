package br.edu.insper.desagil.condominio;

public class Administracao {
	private Pessoa sindico;
	private double orcamento;

	public Administracao() {
		this.sindico = null;
		this.orcamento = 0;
	}

	public Pessoa getSindico() {
		return sindico;
	}
	public void setSindico(Pessoa sindico) {
		this.sindico = sindico;
	}
	public double getOrcamento() {
		return orcamento;
	}

	public void aumenta(double ganho) {
		this.orcamento += ganho;
	}
	public void diminui(double perda) {
		this.orcamento -= perda;
	}
}
