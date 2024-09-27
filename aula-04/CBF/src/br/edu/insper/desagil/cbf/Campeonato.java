package br.edu.insper.desagil.cbf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Campeonato {
	private Date inicio;
	private Date fim;
	private List<Partida> partidas;

	public Campeonato(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
		this.partidas = new ArrayList<>();
	}

	public Date getInicio() {
		return this.inicio;
	}

	public Date getFim() {
		return this.fim;
	}

	public Partida getPartida(int i) {
		return this.partidas.get(i);
	}

	public void adicionaPartida(Equipe vencedor, Equipe perdedor, int pontosVencedor, int pontosPerdedor) {
		Partida partida = new Partida(vencedor, perdedor, pontosVencedor, pontosPerdedor);
		this.partidas.add(partida);
	}
}
