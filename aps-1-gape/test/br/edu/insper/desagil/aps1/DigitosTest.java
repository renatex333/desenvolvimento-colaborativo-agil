package br.edu.insper.desagil.aps1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DigitosTest {
	private Digitos d;

	@BeforeEach
	void setUp() {
		d = new Digitos();
	}

	@Test
	void testA() {
		List<Integer> expected = Arrays.asList(0, 2);
		assertEquals(expected, d.constroi("2C0A"));
	}

	@Test
	void testB() {
		List<Integer> expected = Arrays.asList(1, 3, 5);
		assertEquals(expected, d.constroi("a1c3e5"));
	}

	@Test
	void testC() {
		List<Integer> expected = Arrays.asList(4, 5, 6, 7);
		assertEquals(expected, d.constroi("HGFE3210"));
	}

	@Test
	void testD() {
		List<Integer> expected = Arrays.asList(0, 1, 2, 3);
		assertEquals(expected, d.constroi("6789efgh"));
	}

	@Test
	void testE() {
		List<Integer> expected = Arrays.asList(0);
		assertEquals(expected, d.constroi("5B"));
	}

	@Test
	void testF() {
		List<Integer> expected = Arrays.asList(1);
		assertEquals(expected, d.constroi("a4"));
	}

	@Test
	void testG() {
		List<Integer> expected = Arrays.asList(0);
		assertEquals(expected, d.constroi("3"));
	}

	@Test
	void testH() {
		List<Integer> expected = Arrays.asList();
		assertEquals(expected, d.constroi("A"));
	}

	@Test
	void testI() {
		List<Integer> expected = Arrays.asList();
		assertEquals(expected, d.constroi("abcdefghij"));
	}

	@Test
	void testJ() {
		List<Integer> expected = Arrays.asList();
		assertEquals(expected, d.constroi(""));
	}
}
