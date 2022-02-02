package br.edu.insper.desagil.tinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerfilTest {
	private Gerenciador g;
	
	@BeforeEach
	public void setUp() {
		g = new Gerenciador();
	}
	
	@Test
	public void umPerfilSemAutorizacao() {
		Perfil p = g.cadastraPerfil(1, "Joao");
		assertFalse(p.autoriza());
	}
	
	@Test
	public void doisPerfisBCurteA() {
		Perfil a = g.cadastraPerfil(1, "Joao");
		Perfil b = g.cadastraPerfil(2, "Maria");
		assertFalse(b.curtiu(a));
		b.curte(a);
		assertTrue(b.curtiu(a));
	}
}
