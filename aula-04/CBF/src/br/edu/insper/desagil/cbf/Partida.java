package br.edu.insper.desagil.cbf;

public class Partida {
	private Equipe vencedor;
	private Equipe perdedor;
	private int pontosVencedor;
	private int pontosPerdedor;

	public Partida(Equipe vencedor, Equipe perdedor, int pontosVencedor, int pontosPerdedor) {
		this.vencedor = vencedor;
		this.perdedor = perdedor;
		this.pontosVencedor = pontosVencedor;
		this.pontosPerdedor = pontosPerdedor;
	}

	public Equipe getVencedor() {
		return this.vencedor;
	}

	public Equipe getPerdedor() {
		return this.perdedor;
	}

	public int getPontosVencedor() {
		return this.pontosVencedor;
	}

	public int getPontosPerdedor() {
		return this.pontosPerdedor;
	}
}
