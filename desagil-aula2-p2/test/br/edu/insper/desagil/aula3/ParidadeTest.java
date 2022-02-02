package br.edu.insper.desagil.aula3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParidadeTest {
	private Paridade p;
	private List<Integer> pares;
	private List<Integer> impares;
	private List<List<Integer>> expected;

	@BeforeEach
	private void setUp() {
		p = new Paridade();
		pares = new ArrayList<>();
		impares = new ArrayList<>();
		expected = new ArrayList<>();
		expected.add(pares);
		expected.add(impares);
	}

	@Test
	public void soPares() {
		pares.addAll(Arrays.asList(0, 2, 4, 6, 8));
		impares.addAll(Arrays.asList());
		assertEquals(expected, p.separa(Arrays.asList(0, 2, 4, 6, 8)));
	}

	@Test
	public void soImpares() {
		pares.addAll(Arrays.asList());
		impares.addAll(Arrays.asList(1, 3, 5, 7, 9));
		assertEquals(expected, p.separa(Arrays.asList(1, 3, 5, 7, 9)));
	}

	@Test
	public void paresAntesDeImpares() {
		pares.addAll(Arrays.asList(0, 2, 4, 6, 8));
		impares.addAll(Arrays.asList(1, 3, 5, 7, 9));
		assertEquals(expected, p.separa(Arrays.asList(0, 2, 4, 6, 8, 1, 3, 5, 7, 9)));
	}

	@Test
	public void imparesAntesDePares() {
		pares.addAll(Arrays.asList(0, 2, 4, 6, 8));
		impares.addAll(Arrays.asList(1, 3, 5, 7, 9));
		assertEquals(expected, p.separa(Arrays.asList(1, 3, 5, 7, 9, 0, 2, 4, 6, 8)));
	}

	@Test
	public void paresTrocadosComImpares() {
		pares.addAll(Arrays.asList(0, 2, 4, 6, 8));
		impares.addAll(Arrays.asList(1, 3, 5, 7, 9));
		assertEquals(expected, p.separa(Arrays.asList(1, 0, 3, 2, 5, 4, 7, 6, 9, 8)));
	}

	@Test
	public void totalmenteOrdenado() {
		pares.addAll(Arrays.asList(0, 2, 4, 6, 8));
		impares.addAll(Arrays.asList(1, 3, 5, 7, 9));
		assertEquals(expected, p.separa(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
	}
}
