package br.edu.insper.desagil.tinder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GerenciadorTest {
	private Gerenciador g;
	private Perfil a;
	private Perfil b;
	
	@BeforeEach
	public void setUp() {
		g = new Gerenciador();
		a = g.cadastraPerfil(1, "Joao");
		b = g.cadastraPerfil(2, "Maria");
	}
	
	@Test
	public void ninguemCurtiuNinguemCombinou() {
		assertFalse(a.combinou(b));
		assertFalse(b.combinou(a));
	}
	
	@Test
	public void ACurtiuBNinguemCombinou() {
		a.curte(b);
		assertFalse(a.combinou(b));
		assertFalse(b.combinou(a));
	}
	
	@Test
	public void BCurtiuANinguemCombinou() {
		b.curte(a);
		assertFalse(a.combinou(b));
		assertFalse(b.combinou(a));
	}
	
	@Test
	public void ambosCurtiramECombinou() {
		b.curte(a);
		a.curte(b);
		assertTrue(a.combinou(b));
		assertTrue(b.combinou(a));
	}
	
	
}
