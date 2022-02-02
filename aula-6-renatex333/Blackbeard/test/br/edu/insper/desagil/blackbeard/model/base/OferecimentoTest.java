package br.edu.insper.desagil.blackbeard.model.base;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OferecimentoTest {
	private Oferecimento oferecimento;

	@BeforeEach
	public void setUp() {
		oferecimento = new Oferecimento(new Disciplina("DESSOFT", "Design de Software"));
	}

	@Test
	public void testConstructor() {
		List<String> expectedEmenta = new ArrayList<>();
		Map<Date, String> expectedPlano = new HashMap<>();

		assertEquals("DESSOFT", oferecimento.getDisciplina().getCodigo());
		assertEquals("Design de Software", oferecimento.getDisciplina().getNome());
		assertEquals(expectedEmenta, oferecimento.getDisciplina().getEmenta());
		assertEquals(expectedPlano, oferecimento.getPlano());
	}
	
	@Test
	public void testUmaMatricula() {
		Aluno aluno = new Aluno(1, "João");
		oferecimento.matricula(aluno);
		assertTrue(oferecimento.temMatricula(1));
	}
}
