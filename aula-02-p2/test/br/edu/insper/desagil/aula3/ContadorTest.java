package br.edu.insper.desagil.aula3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContadorTest {
	private Map<Character, Integer> expected;
	private Contador c;

	@BeforeEach
	private void setUp() {
		expected = new HashMap<>();
		c = new Contador();
	}

	@Test
	public void banana() {
		expected.put('b', 1);
		expected.put('a', 3);
		expected.put('n', 2);
		assertEquals(expected, c.calcula("banana"));
	}

	@Test
	public void abobora() {
		expected.put('a', 2);
		expected.put('b', 2);
		expected.put('o', 2);
		expected.put('r', 1);
		assertEquals(expected, c.calcula("abobora"));
	}

	@Test
	public void a() {
		expected.put('a', 1);
		assertEquals(expected, c.calcula("a"));
	}

	@Test
	public void b() {
		expected.put('b', 1);
		assertEquals(expected, c.calcula("b"));
	}

	@Test
	public void aa() {
		expected.put('a', 2);
		assertEquals(expected, c.calcula("aa"));
	}

	@Test
	public void ab() {
		expected.put('a', 1);
		expected.put('b', 1);
		assertEquals(expected, c.calcula("ab"));
	}

	@Test
	public void ba() {
		expected.put('a', 1);
		expected.put('b', 1);
		assertEquals(expected, c.calcula("ba"));
	}

	@Test
	public void bb() {
		expected.put('b', 2);
		assertEquals(expected, c.calcula("bb"));
	}

	@Test
	public void aaa() {
		expected.put('a', 3);
		assertEquals(expected, c.calcula("aaa"));
	}

	@Test
	public void aab() {
		expected.put('a', 2);
		expected.put('b', 1);
		assertEquals(expected, c.calcula("aab"));
	}

	@Test
	public void aba() {
		expected.put('a', 2);
		expected.put('b', 1);
		assertEquals(expected, c.calcula("aba"));
	}

	@Test
	public void abb() {
		expected.put('a', 1);
		expected.put('b', 2);
		assertEquals(expected, c.calcula("abb"));
	}

	@Test
	public void baa() {
		expected.put('a', 2);
		expected.put('b', 1);
		assertEquals(expected, c.calcula("baa"));
	}

	@Test
	public void bab() {
		expected.put('a', 1);
		expected.put('b', 2);
		assertEquals(expected, c.calcula("bab"));
	}

	@Test
	public void bba() {
		expected.put('a', 1);
		expected.put('b', 2);
		assertEquals(expected, c.calcula("bba"));
	}

	@Test
	public void bbb() {
		expected.put('b', 3);
		assertEquals(expected, c.calcula("bbb"));
	}
}
