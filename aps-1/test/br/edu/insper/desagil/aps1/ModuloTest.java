package br.edu.insper.desagil.aps1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModuloTest {
	private Modulo m;

	@BeforeEach
	void setUp() {
		m = new Modulo();
	}

	@Test
	void umPositivo() {
		List<Integer> numeros = Arrays.asList(1);
		assertEquals(1, m.maior(numeros));
	}

	@Test
	void umNegativo() {
		List<Integer> numeros = Arrays.asList(-1);
		assertEquals(-1, m.maior(numeros));
	}

	@Test
	void doisPositivosCrescentes() {
		List<Integer> numeros = Arrays.asList(1, 2);
		assertEquals(2, m.maior(numeros));
	}

	@Test
	void doisNegativosCrescentes() {
		List<Integer> numeros = Arrays.asList(-2, -1);
		assertEquals(-2, m.maior(numeros));
	}

	@Test
	void doisPositivosDecrescentes() {
		List<Integer> numeros = Arrays.asList(2, 1);
		assertEquals(2, m.maior(numeros));
	}

	@Test
	void doisNegativosDecrescentes() {
		List<Integer> numeros = Arrays.asList(-1, -2);
		assertEquals(-2, m.maior(numeros));
	}

	@Test
	void tresPositivos() {
		List<Integer> numeros = Arrays.asList(2, 3, 1);
		assertEquals(3, m.maior(numeros));
	}

	@Test
	void doisPositivosUmNegativoMenor() {
		List<Integer> numeros = Arrays.asList(3, -1, 2);
		assertEquals(3, m.maior(numeros));
	}

	@Test
	void doisPositivosUmNegativoMaior() {
		List<Integer> numeros = Arrays.asList(2, -3, 1);
		assertEquals(-3, m.maior(numeros));
	}

	@Test
	void umPositivoMenorDoisNegativos() {
		List<Integer> numeros = Arrays.asList(-3, 1, -2);
		assertEquals(-3, m.maior(numeros));
	}

	@Test
	void umPositivoMaiorDoisNegativos() {
		List<Integer> numeros = Arrays.asList(-2, 3, -1);
		assertEquals(3, m.maior(numeros));
	}

	@Test
	void tresNegativos() {
		List<Integer> numeros = Arrays.asList(-1, -3, -2);
		assertEquals(-3, m.maior(numeros));
	}
}
