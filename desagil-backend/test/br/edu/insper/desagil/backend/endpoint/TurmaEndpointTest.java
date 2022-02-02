package br.edu.insper.desagil.backend.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Turma;
import br.edu.insper.desagil.backend.httpserver.EndpointTest;
import br.edu.insper.desagil.backend.httpserver.Result;
import br.edu.insper.desagil.backend.httpserver.exception.ResponseException;

class TurmaEndpointTest extends EndpointTest<Turma> {
	@BeforeEach
	public void setUp() {
		start(Backend.URL, "/turma");
		delete("all=true");
	}

	@Test
	public void testPost() {
		List<String> matriculas = new ArrayList<>();
		matriculas.add("1");
		Turma turma = new Turma(matriculas);
		Result result = post(turma);
		String key = (String) result.get("key");
		turma = get("key=" + key);
		assertEquals(matriculas, turma.getMatriculas());
	}

	@Test
	public void testPut() {
		List<String> matriculas = new ArrayList<>();
		matriculas.add("1");
		Turma turma = new Turma(matriculas);
		Result result = post(turma);
		String key = (String) result.get("key");
		matriculas = new ArrayList<>();
		matriculas.add("2");
		turma.setKey(key);
		turma.setMatriculas(matriculas);
		put(turma);
		turma = get("key=" + key);
		assertEquals(matriculas, turma.getMatriculas());
	}

	@Test
	public void testDelete() {
		List<String> matriculas = new ArrayList<>();
		matriculas.add("1");
		Turma turma = new Turma(matriculas);
		Result result = post(turma);
		String key = (String) result.get("key");
		delete("key=" + key);
		assertThrows(ResponseException.class, () -> {
			get("key=" + key);
		});
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}