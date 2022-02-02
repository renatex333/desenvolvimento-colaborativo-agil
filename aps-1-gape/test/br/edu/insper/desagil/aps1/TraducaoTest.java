package br.edu.insper.desagil.aps1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TraducaoTest {
	private static final double DELTA = 0.01;

	private List<Map<String, Double>> pessoas;
	private Map<String, List<Double>> expected;
	private Traducao t;

	Map<String, Double> buildPessoa(double idade, double altura, double peso) {
		Map<String, Double> pessoa = new HashMap<>();
		pessoa.put("idade", idade);
		pessoa.put("altura", altura);
		pessoa.put("peso", peso);
		return pessoa;
	}

	void compare(Map<String, List<Double>> expected, Map<String, List<Double>> actual) {
		for (String key: expected.keySet()) {
			List<Double> e = expected.get(key);
			List<Double> a = actual.get(key);
			for (int i = 0; i < e.size(); i++) {
				assertEquals(e.get(i), a.get(i), DELTA);
			}
		}
	}

	@BeforeEach
	void setUp() {
		pessoas = new ArrayList<>();
		expected = new HashMap<>();
		t = new Traducao();
	}

	@Test
	void testA() {
		pessoas.add(buildPessoa(25, 1.85, 80));
		pessoas.add(buildPessoa(60, 1.68, 75));
		pessoas.add(buildPessoa(18, 1.5, 60));
		expected.put("age", Arrays.asList(25.0, 60.0, 18.0));
		expected.put("height", Arrays.asList(72.83, 66.14, 59.05));
		expected.put("weight", Arrays.asList(176.37, 165.34, 132.27));
		compare(expected, t.constroi(pessoas));
	}
}
