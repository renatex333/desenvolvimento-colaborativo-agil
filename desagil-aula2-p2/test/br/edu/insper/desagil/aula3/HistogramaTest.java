package br.edu.insper.desagil.aula3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HistogramaTest {
	private List<Integer> expected;
	private Histograma h;

	@BeforeEach
	private void setUp() {
		h = new Histograma();
	}

	@Test
	public void todosOsDigitosUmaVez() {
		expected = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		assertEquals(expected, h.calcula(Arrays.asList(9, 0, 8, 1, 7, 2, 6, 3, 5, 4)));
	}

	@Test
	public void zeroNoveNenhumaVezOutrosUmaVez() {
		expected = Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1, 0);
		assertEquals(expected, h.calcula(Arrays.asList(8, 1, 7, 2, 6, 3, 5, 4)));
	}

	@Test
	public void umOitoUmaVezOutrosNenhumaVez() {
		expected = Arrays.asList(0, 1, 0, 0, 0, 0, 0, 0, 1, 0);
		assertEquals(expected, h.calcula(Arrays.asList(8, 1)));
	}

	@Test
	public void doisSeteDuasVezesOutrosUmaVez() {
		expected = Arrays.asList(1, 1, 2, 1, 1, 1, 1, 2, 1, 1);
		assertEquals(expected, h.calcula(Arrays.asList(9, 0, 8, 1, 7, 2, 2, 7, 6, 3, 5, 4)));
	}

	@Test
	public void tresSeisTresVezesOutrosUmaVez() {
		expected = Arrays.asList(1, 1, 1, 3, 1, 1, 3, 1, 1, 1);
		assertEquals(expected, h.calcula(Arrays.asList(9, 0, 3, 8, 6, 1, 6, 7, 3, 2, 6, 3, 5, 4)));
	}

	@Test
	public void quatroCincoQuatroVezesOutrosUmaVez() {
		expected = Arrays.asList(1, 1, 1, 1, 4, 4, 1, 1, 1, 1);
		assertEquals(expected, h.calcula(Arrays.asList(4, 4, 5, 5, 9, 0, 8, 1, 7, 2, 6, 3, 5, 5, 4, 4)));
	}

}
