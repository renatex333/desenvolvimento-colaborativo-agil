package br.edu.insper.desagil.aula3;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaTest {
	private static double DELTA = 0.000001;

	private Media m;
	List<Map<String, Integer>> notas;

	private Map<String, Integer> build(int peso, int valor) {
		Map<String, Integer> nota = new HashMap<>();
		nota.put("peso", peso);
		nota.put("valor", valor);
		return nota;
	}

	@BeforeEach
	private void setUp() {
		m = new Media();
		notas = new ArrayList<>();
	}

	@Test
	public void pesoUmValorZero() {
		notas.add(build(1, 0));
		assertEquals(0.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorCinco() {
		notas.add(build(2, 5));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoTresValorDez() {
		notas.add(build(3, 10));
		assertEquals(10.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoUmValorZero() {
		notas.add(build(1, 0));
		notas.add(build(1, 0));
		assertEquals(0.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorCincoPesoUmValorCinco() {
		notas.add(build(1, 5));
		notas.add(build(1, 5));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorDezPesoUmValorDez() {
		notas.add(build(1, 10));
		notas.add(build(1, 10));
		assertEquals(10.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoDoisValorZero() {
		notas.add(build(1, 0));
		notas.add(build(2, 0));
		assertEquals(0.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorCincoPesoDoisValorCinco() {
		notas.add(build(1, 5));
		notas.add(build(2, 5));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorDezPesoDoisValorDez() {
		notas.add(build(1, 10));
		notas.add(build(2, 10));
		assertEquals(10.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoUmValorZero() {
		notas.add(build(2, 0));
		notas.add(build(1, 0));
		assertEquals(0.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorCincoPesoUmValorCinco() {
		notas.add(build(2, 5));
		notas.add(build(1, 5));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorDezPesoUmValorDez() {
		notas.add(build(2, 10));
		notas.add(build(1, 10));
		assertEquals(10.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoDoisValorZero() {
		notas.add(build(2, 0));
		notas.add(build(2, 0));
		assertEquals(0.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorCincoPesoDoisValorCinco() {
		notas.add(build(2, 5));
		notas.add(build(2, 5));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorDezPesoDoisValorDez() {
		notas.add(build(2, 10));
		notas.add(build(2, 10));
		assertEquals(10.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoUmValorCinco() {
		notas.add(build(1, 0));
		notas.add(build(1, 5));
		assertEquals(2.5, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoUmValorDez() {
		notas.add(build(1, 0));
		notas.add(build(1, 10));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorCincoPesoUmValorDez() {
		notas.add(build(1, 5));
		notas.add(build(1, 10));
		assertEquals(7.5, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoDoisValorCinco() {
		notas.add(build(1, 0));
		notas.add(build(2, 5));
		assertEquals(3.333333, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoDoisValorDez() {
		notas.add(build(1, 0));
		notas.add(build(2, 10));
		assertEquals(6.666666, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorCincoPesoDoisValorDez() {
		notas.add(build(1, 5));
		notas.add(build(2, 10));
		assertEquals(8.333333, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoUmValorCinco() {
		notas.add(build(2, 0));
		notas.add(build(1, 5));
		assertEquals(1.666666, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoUmValorDez() {
		notas.add(build(2, 0));
		notas.add(build(1, 10));
		assertEquals(3.333333, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorCincoPesoUmValorDez() {
		notas.add(build(2, 5));
		notas.add(build(1, 10));
		assertEquals(6.666666, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoDoisValorCinco() {
		notas.add(build(2, 0));
		notas.add(build(2, 5));
		assertEquals(2.5, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorZeroPesoDoisValorDez() {
		notas.add(build(2, 0));
		notas.add(build(2, 10));
		assertEquals(5.0, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoDoisValorCincoPesoDoisValorDez() {
		notas.add(build(2, 5));
		notas.add(build(2, 10));
		assertEquals(7.5, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoUmValorZeroPesoDoisValorCincoPesoTresValorDez() {
		notas.add(build(1, 0));
		notas.add(build(2, 5));
		notas.add(build(3, 10));
		assertEquals(6.666666, m.calcula(notas), DELTA);
	}

	@Test
	public void pesoTresValorZeroPesoDoisValorCincoPesoUmValorDez() {
		notas.add(build(3, 0));
		notas.add(build(2, 5));
		notas.add(build(1, 10));
		assertEquals(3.333333, m.calcula(notas), DELTA);
	}

	@Test
	public void exemploEnunciado() {
		notas.add(build(1, 3));
		notas.add(build(2, 4));
		notas.add(build(3, 5));
		notas.add(build(2, 6));
		notas.add(build(1, 9));
		assertEquals(5.222222, m.calcula(notas), DELTA);
	}
}
