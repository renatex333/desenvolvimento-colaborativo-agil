package br.edu.insper.desagil.cbf;

public class Jogador {
	private String nome;
	private int forca;
	private int velocidade;
	private int resistencia;

	public Jogador(String nome, int forca, int velocidade, int resistencia) {
		this.nome = nome;
		this.forca = forca;
		this.velocidade = velocidade;
		this.resistencia = resistencia;
	}

	public int getForca() {
		return this.forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getVelocidade() {
		return this.velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public int getResistencia() {
		return this.resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public String getNome() {
		return this.nome;
	}
}
