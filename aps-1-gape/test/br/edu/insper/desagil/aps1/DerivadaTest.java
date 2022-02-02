package br.edu.insper.desagil.aps1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DerivadaTest {
	private Derivada d;

	@BeforeEach
	void setUp() {
		d = new Derivada();
	}

	@Test
	void doisZero() {
		List<Integer> expected = Arrays.asList(0);
		assertEquals(expected, d.constroi(Arrays.asList(1, 1)));
	}

	@Test
	void doisPositivo() {
		List<Integer> expected = Arrays.asList(1);
		assertEquals(expected, d.constroi(Arrays.asList(1, 2)));
	}

	@Test
	void doisNegativo() {
		List<Integer> expected = Arrays.asList(-1);
		assertEquals(expected, d.constroi(Arrays.asList(2, 1)));
	}

	@Test
	void tresZeroZero() {
		List<Integer> expected = Arrays.asList(0, 0);
		assertEquals(expected, d.constroi(Arrays.asList(1, 1, 1)));
	}

	@Test
	void tresZeroPositivo() {
		List<Integer> expected = Arrays.asList(0, 1);
		assertEquals(expected, d.constroi(Arrays.asList(1, 1, 2)));
	}

	@Test
	void tresZeroNegativo() {
		List<Integer> expected = Arrays.asList(0, -1);
		assertEquals(expected, d.constroi(Arrays.asList(2, 2, 1)));
	}

	@Test
	void tresPositivoZero() {
		List<Integer> expected = Arrays.asList(1, 0);
		assertEquals(expected, d.constroi(Arrays.asList(1, 2, 2)));
	}

	@Test
	void tresPositivoPositivo() {
		List<Integer> expected = Arrays.asList(1, 1);
		assertEquals(expected, d.constroi(Arrays.asList(1, 2, 3)));
	}

	@Test
	void tresPositivoNegativo() {
		List<Integer> expected = Arrays.asList(1, -1);
		assertEquals(expected, d.constroi(Arrays.asList(1, 2, 1)));
	}

	@Test
	void tresNegativoZero() {
		List<Integer> expected = Arrays.asList(-1, 0);
		assertEquals(expected, d.constroi(Arrays.asList(2, 1, 1)));
	}

	@Test
	void tresNegativoPositivo() {
		List<Integer> expected = Arrays.asList(-1, 1);
		assertEquals(expected, d.constroi(Arrays.asList(2, 1, 2)));
	}

	@Test
	void tresNegativoNegativo() {
		List<Integer> expected = Arrays.asList(-1, -1);
		assertEquals(expected, d.constroi(Arrays.asList(3, 2, 1)));
	}
}
