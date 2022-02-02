package br.edu.insper.desagil.tinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerfilPremiumTest {
	private Gerenciador g;
	
	@BeforeEach
	public void setUp() {
		g = new Gerenciador();
	}
	
	@Test
	public void umPerfilPremium5PontosSemAutorizacao() {
		PerfilPremium p = g.cadastraPerfilPremium(1, "Joao");
		p.adicionaPontos(5);
		assertFalse(p.autoriza());
		assertEquals(5, p.getPontos());
	}
	
	@Test
	public void umPerfilPremium15PontosComAutorizacao() {
		PerfilPremium p = g.cadastraPerfilPremium(1, "Joao");
		p.adicionaPontos(15);
		assertTrue(p.autoriza());
		assertEquals(5, p.getPontos());
	}
}
