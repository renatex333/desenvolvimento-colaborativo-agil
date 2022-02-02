package br.edu.insper.desagil.crud.dao;


//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.crud.Aluno;
import br.edu.insper.desagil.crud.CRUD;
import br.edu.insper.desagil.crud.database.DatabaseException;

class AlunoDAOTest {
	private AlunoDAO dao;

	@BeforeAll
	public static void setUpClass() throws IOException {
		CRUD.setUp("firestore.json");
	}

	@BeforeEach
	public void setUp() throws DatabaseException {
		dao = new AlunoDAO();
		dao.deleteAll();
	}

	@Test
	public void criaQuatroAlunosDiferentes() throws DatabaseException {
		Aluno aluno1 = new Aluno(1, "Maria", true, 4.5);
		Aluno aluno2 = new Aluno(2, "José", false, 10.0);
		Aluno aluno3 = new Aluno(3, "Mariana", true, 5.5);
		Aluno aluno4 = new Aluno(4, "João", false, 0.0);

		dao.create(aluno1);
		dao.create(aluno2);
		dao.create(aluno3);
		dao.create(aluno4);

		assertTrue(dao.exists("1"));
		assertTrue(dao.exists("2"));
		assertTrue(dao.exists("3"));
		assertTrue(dao.exists("4"));
		
		aluno1 = dao.retrieve("1");
		aluno2 = dao.retrieve("2");
		aluno3 = dao.retrieve("3");
		aluno4 = dao.retrieve("4");
		
		
		assertEquals(1, aluno1.getMatricula());
		assertEquals(2, aluno2.getMatricula());
		assertEquals(3, aluno3.getMatricula());
		assertEquals(4, aluno4.getMatricula());
		
		assertEquals("Maria", aluno1.getNome());
		assertEquals("José", aluno2.getNome());
		assertEquals("Mariana", aluno3.getNome());
		assertEquals("João", aluno4.getNome());
		
		assertTrue(aluno1.isRegular());
		assertFalse(aluno2.isRegular());
		assertTrue(aluno3.isRegular());
		assertFalse(aluno4.isRegular());
		
		assertEquals(4.5, aluno1.getCr(), 0.001);
		assertEquals(10, aluno2.getCr(), 0.001);
		assertEquals(5.5, aluno3.getCr(), 0.001);
		assertEquals(0.0, aluno4.getCr(), 0.001);
	}
	
	@Test
	public void criaAlunoEAtualiza() throws DatabaseException {
		Aluno aluno = new Aluno(1, "Maria", true, 4.5);

		dao.create(aluno);

		aluno.setRegular(false);
		aluno.setCr(5.5);

		dao.update(aluno);

		aluno = dao.retrieve("1");
		
		assertEquals(1, aluno.getMatricula());
	    assertEquals("Maria", aluno.getNome());
	    assertEquals(false, aluno.isRegular());
	    assertEquals(5.5, aluno.getCr(), 0.001);
	}
	
	@Test
	public void criaAlunoEApaga() throws DatabaseException {
		Aluno aluno = new Aluno(1, "Maria", true, 4.5);

		dao.create(aluno);

		dao.delete("1");

		assertFalse(dao.exists("1"));
	}

	@AfterAll
	public static void tearDownClass() {
		CRUD.tearDown();
	}
}
