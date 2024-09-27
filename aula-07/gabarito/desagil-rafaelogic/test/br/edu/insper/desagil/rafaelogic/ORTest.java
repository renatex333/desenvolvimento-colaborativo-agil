package br.edu.insper.desagil.rafaelogic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ORTest {
	private OR porta;

	@BeforeEach
	public void setUp() {
		porta = new OR();
	}

	@Test
	public void testFalseFalse() {
		assertFalse(porta.getSaida(false, false));
	}

	@Test
	public void testFalseTrue() {
		assertTrue(porta.getSaida(false, true));
	}

	@Test
	public void testTrueFalse() {
		assertTrue(porta.getSaida(true, false));
	}

	@Test
	public void testTrueTrue() {
		assertTrue(porta.getSaida(true, true));
	}
}
