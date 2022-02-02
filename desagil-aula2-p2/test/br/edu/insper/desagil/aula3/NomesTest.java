package br.edu.insper.desagil.aula3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NomesTest {
	private Nomes n;
	private Map<String, List<String>> d;
	private Map<String, List<String>> expected;

	@BeforeEach
	private void setUp() {
		n = new Nomes();
		d = new HashMap<>();
		expected = new HashMap<>();
	}

	@Test
	public void testUmNomeUmSobrenome() {
		d.put("joao", Arrays.asList("silva"));
		expected.put("silva", Arrays.asList("joao"));
		assertEquals(expected, n.inverte(d));
	}

	@Test
	public void testUmNomeDoisSobrenomes() {
		d.put("joao", Arrays.asList("silva", "souza"));
		expected.put("silva", Arrays.asList("joao"));
		expected.put("souza", Arrays.asList("joao"));
		assertEquals(expected, n.inverte(d));
	}

	@Test
	public void testDoisNomesUmSobrenome() {
		d.put("joao", Arrays.asList("silva"));
		d.put("jose", Arrays.asList("silva"));
		expected.put("silva", Arrays.asList("joao", "jose"));
		assertEquals(expected, n.inverte(d));
	}

	@Test
	public void testDoisNomesDoisSobrenomes() {
		d.put("joao", Arrays.asList("silva", "souza"));
		d.put("jose", Arrays.asList("silva", "souza"));
		expected.put("silva", Arrays.asList("joao", "jose"));
		expected.put("souza", Arrays.asList("joao", "jose"));
		assertEquals(expected, n.inverte(d));
	}

	@Test
	public void exemploEnunciado() {
		d.put("joao", Arrays.asList("silva", "souza"));
		d.put("maria", Arrays.asList("silva"));
		d.put("mariana", Arrays.asList("souza"));
		expected.put("silva", Arrays.asList("joao", "maria"));
		expected.put("souza", Arrays.asList("joao", "mariana"));
		assertEquals(expected, n.inverte(d));
	}
}
