package br.edu.insper.desagil.rafaelogic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ANDTest {
	private AND porta;

	@BeforeEach
	public void setUp() {
		porta = new AND();
	}

	@Test
	public void testFalseFalse() {
		assertFalse(porta.getSaida(false, false));
	}

	@Test
	public void testFalseTrue() {
		assertFalse(porta.getSaida(false, true));
	}

	@Test
	public void testTrueFalse() {
		assertFalse(porta.getSaida(true, false));
	}

	@Test
	public void testTrueTrue() {
		assertTrue(porta.getSaida(true, true));
	}
}
