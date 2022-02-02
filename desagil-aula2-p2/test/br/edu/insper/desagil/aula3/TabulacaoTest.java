package br.edu.insper.desagil.aula3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TabulacaoTest {
	private static double DELTA = 0.000001;

	private Tabulacao t;
	private List<Map<String, String>> alunos;
	private Map<String, Double> expected;

	private Map<String, String> build(String nome, String curso) {
		Map<String, String> aluno = new HashMap<>();
		aluno.put("nome", nome);
		aluno.put("curso", curso);
		return aluno;
	}

	@BeforeEach
	private void setUp() {
		t = new Tabulacao();
		alunos = new ArrayList<>();
		expected = new HashMap<>();
	}

	@Test
	public void soComp() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "COMP"));
		alunos.add(build("Mariana", "COMP"));
		alunos.add(build("José", "COMP"));
		expected.put("COMP", 100.0);
		assertEquals(expected, t.monta(alunos));
	}

	@Test
	public void tresCompUmMecat() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "COMP"));
		alunos.add(build("Mariana", "COMP"));
		alunos.add(build("José", "MECAT"));
		expected.put("COMP", 75.0);
		expected.put("MECAT", 25.0);
		assertEquals(expected, t.monta(alunos));
	}

	@Test
	public void doisCompDoisMecat() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "COMP"));
		alunos.add(build("Mariana", "MECAT"));
		alunos.add(build("José", "MECAT"));
		expected.put("COMP", 50.0);
		expected.put("MECAT", 50.0);
		assertEquals(expected, t.monta(alunos));
	}

	@Test
	public void doisCompUmMecatUmMec() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "COMP"));
		alunos.add(build("Mariana", "MECAT"));
		alunos.add(build("José", "MEC"));
		expected.put("COMP", 50.0);
		expected.put("MECAT", 25.0);
		expected.put("MEC", 25.0);
		assertEquals(expected, t.monta(alunos));
	}

	@Test
	public void doisCompUmMecat() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "COMP"));
		alunos.add(build("Mariana", "MECAT"));
		expected.put("COMP", 66.66666666666666);
		expected.put("MECAT", 33.33333333333333);
	}

	@Test
	public void umCompUmMecat() {
		alunos.add(build("Maria", "COMP"));
		alunos.add(build("João", "MECAT"));
		expected.put("COMP", 50.0);
		expected.put("MECAT", 50.0);
	}

	@Test
	public void exemploEnunciado() {
		alunos.add(build("Mariana Souza", "MEC"));
		alunos.add(build("José Silva", "COMP"));
		alunos.add(build("João Souza", "COMP"));
		alunos.add(build("João Silva", "MECAT"));
		alunos.add(build("Maria Silva", "MEC"));
		alunos.add(build("Mariana Silva", "COMP"));
		expected.put("MEC", 33.33333333333333);
		expected.put("COMP", 50.0);
		expected.put("MECAT", 16.66666666666666);
	}
}
