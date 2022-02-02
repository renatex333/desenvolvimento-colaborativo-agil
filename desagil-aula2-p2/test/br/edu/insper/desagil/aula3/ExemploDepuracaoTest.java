package br.edu.insper.desagil.aula3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExemploDepuracaoTest {
	private static Double DELTA = 0.000001;

	private double expected;
	private ExemploDepuracao e;
	private List<Integer> valores;
	private int maximo;

	@BeforeEach
	private void setUp() {
		expected = 20.0;
		e = new ExemploDepuracao();
		valores = Arrays.asList(1, 2, 3);
		maximo = 10;
	}

	@Test
	public void testExemploErrado() {
		assertEquals(expected, e.exemploErrado(valores, maximo), DELTA);
	}

	@Test
	public void testExemploCerto() {
		assertEquals(expected, e.exemploCerto(valores, maximo), DELTA);
	}

	@Test
	public void testExemploReescrito() {
		assertEquals(expected, e.exemploReescrito(valores, maximo), DELTA);
	}
}
