
package br.edu.insper.desagil.backend.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Aluno;
import br.edu.insper.desagil.backend.httpserver.EndpointTest;
import br.edu.insper.desagil.backend.httpserver.exception.ResponseException;

class AlunoEndpointTest extends EndpointTest<Aluno> {
	private static final double DELTA = 0.000001;

	@BeforeEach
	public void setUp() {
		start(Backend.URL, "/aluno");
		delete("all=true");
	}

	@Test
	public void testPost() {
		Aluno aluno = new Aluno(1, "Maria", true, 4.5);
		post(aluno);
		aluno = get("key=1");
		assertEquals(1, aluno.getMatricula());
		assertEquals("Maria", aluno.getNome());
		assertEquals(true, aluno.isRegular());
		assertEquals(4.5, aluno.getCr(), DELTA);
	}

	@Test
	public void testPut() {
		Aluno aluno = new Aluno(1, "Maria", true, 4.5);
		post(aluno);
		aluno.setNome("José");
		aluno.setRegular(false);
		aluno.setCr(10.0);
		put(aluno);
		aluno = get("key=1");
		assertEquals(1, aluno.getMatricula());
		assertEquals("José", aluno.getNome());
		assertEquals(false, aluno.isRegular());
		assertEquals(10.0, aluno.getCr(), DELTA);
	}

	@Test
	public void testDelete() {
		Aluno aluno = new Aluno(1, "Maria", true, 4.5);
		post(aluno);
		delete("key=1");
		assertThrows(ResponseException.class, () -> {
			get("key=1");
		});
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}