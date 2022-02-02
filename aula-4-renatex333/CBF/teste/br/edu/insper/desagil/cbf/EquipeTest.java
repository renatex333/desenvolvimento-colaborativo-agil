package br.edu.insper.desagil.cbf;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EquipeTest {
	private Equipe equipe;
	
	@BeforeEach
	public void setUp() {
		equipe = new Equipe("Palmeiras");
	}
	
	@Test
	public void adicionaUmJogador() {
		Jogador jogador = new Jogador("Ronaldo", 5, 7, 9);
		equipe.adicionaJogador(jogador);
		assertEquals(1, equipe.getNumJogadores());
		assertEquals("Ronaldo", equipe.getJogador(0).getNome());
	}
	
	@Test
	public void adicionaDoisJogadores() {
		Jogador jogadorUm = new Jogador("Ronaldo", 5, 7, 9);
		Jogador jogadorDois = new Jogador("Arnaldo", 7, 9, 11);
		equipe.adicionaJogador(jogadorUm);
		equipe.adicionaJogador(jogadorDois);
		assertEquals(2, equipe.getNumJogadores());
		assertEquals("Ronaldo", equipe.getJogador(0).getNome());
		assertEquals("Arnaldo", equipe.getJogador(1).getNome());
	}
	
}
