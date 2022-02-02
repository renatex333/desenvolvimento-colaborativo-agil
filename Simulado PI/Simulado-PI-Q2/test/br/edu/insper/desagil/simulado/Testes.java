package br.edu.insper.desagil.simulado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Testes {
	private Usuario u;
	private Produto p;

	@BeforeEach
	public void setUp() {
		u = new Usuario("Margarida");
		p = new Produto("Lixo", 41.99);
	}

	@Test
	public void umVideoComNenhumaAvaliacaoValida() {
		Video video = u.postaVideo(1, p);
		video.adicionaAvaliacao(u, 4);
		video.adicionaAvaliacao(new Usuario("Jose"), 0);
		video.adicionaAvaliacao(new Usuario("Joao"), 6);
		assertEquals(0, u.totalAvaliacoes());
	}
	
	@Test
	public void umVideoComUmaAvaliacao() {
		Video video = u.postaVideo(1, p);
		video.adicionaAvaliacao(new Usuario("Jose"), 2);
		assertEquals(2, u.totalAvaliacoes());
	}
	
	@Test
	public void umVideoComDuasAvaliacoes() {
		Video video = u.postaVideo(1, p);
		video.adicionaAvaliacao(new Usuario("Jose"), 2);
		video.adicionaAvaliacao(new Usuario("Joao"), 5);
		assertEquals(4, u.totalAvaliacoes());
	}
	
	@Test
	public void umVideoComTresAvaliacoes() {
		Video video = u.postaVideo(1, p);
		video.adicionaAvaliacao(new Usuario("Jose"), 2);
		video.adicionaAvaliacao(new Usuario("Joao"), 5);
		video.adicionaAvaliacao(new Usuario("Jeraldo"), 3);
		assertEquals(3, u.totalAvaliacoes());
	}
	
	@Test
	public void umVideoComDuasAvaliacoesUmVideoComUmaAvaliacao() {
		Video video = u.postaVideo(1, p);
		video.adicionaAvaliacao(new Usuario("Jose"), 2);
		video.adicionaAvaliacao(new Usuario("Joao"), 5);
		
		Video video2 = u.postaVideo(2, p);
		video2.adicionaAvaliacao(new Usuario("Jeraldo"), 3);
		assertEquals(7, u.totalAvaliacoes());
	}

}
