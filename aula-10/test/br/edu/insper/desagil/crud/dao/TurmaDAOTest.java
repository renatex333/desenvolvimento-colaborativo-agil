package br.edu.insper.desagil.crud.dao;

//import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.crud.CRUD;
import br.edu.insper.desagil.crud.Turma;
import br.edu.insper.desagil.crud.database.DatabaseException;

class TurmaDAOTest {
	private TurmaDAO dao;

	@BeforeAll
	public static void setUpClass() throws IOException {
		CRUD.setUp("firestore.json");
	}

	@BeforeEach
	public void setUp() throws DatabaseException {
		dao = new TurmaDAO();
		dao.deleteAll();
	}

	@Test
	public void criaDuasTurmasDiferentes() throws DatabaseException {
	    List<String> matriculas1 = new ArrayList<>();
	    matriculas1.add("1");
	    matriculas1.add("2");

	    List<String> matriculas2 = new ArrayList<>();
	    matriculas2.add("3");
	    matriculas2.add("4");

	    Turma turma1 = new Turma(matriculas1);
	    Turma turma2 = new Turma(matriculas2);

	    dao.create(turma1);
	    dao.create(turma2);

	    String key1 = turma1.getKey();
	    String key2 = turma2.getKey();

	    assertTrue(dao.exists(key1));
	    assertTrue(dao.exists(key2));

	    turma1 = dao.retrieve(key1);
	    turma2 = dao.retrieve(key2);

	    matriculas1 = new ArrayList<>();
	    matriculas1.add("1");
	    matriculas1.add("2");

	    matriculas2 = new ArrayList<>();
	    matriculas2.add("3");
	    matriculas2.add("4");

	    assertEquals(matriculas1, turma1.getMatriculas());
	    assertEquals(matriculas2, turma2.getMatriculas());
	}
	
	@Test
	public void criaTurmaEAtualiza() throws DatabaseException {
	    List<String> matriculas = new ArrayList<>();
	    matriculas.add("1");
	    matriculas.add("2");

	    Turma turma = new Turma(matriculas);

	    dao.create(turma);

	    String key = turma.getKey();

	    matriculas = new ArrayList<>();
	    matriculas.add("3");
	    matriculas.add("4");

	    turma.setMatriculas(matriculas);

	    dao.update(turma);

	    turma = dao.retrieve(key);

	    // Reconstruo a lista para ter certeza
	    // de que o conteúdo é igual, não o objeto.

	    matriculas = new ArrayList<>();
	    matriculas.add("3");
	    matriculas.add("4");

	    assertEquals(matriculas, turma.getMatriculas());
	}
	
	@Test
	public void criaTurmaEApaga() throws DatabaseException {
	    List<String> matriculas = new ArrayList<>();
	    matriculas.add("1");
	    matriculas.add("2");

	    Turma turma = new Turma(matriculas);

	    dao.create(turma);

	    String key = turma.getKey();

	    dao.delete(key);

	    assertFalse(dao.exists(key));
	}
	
	@AfterAll
	public static void tearDownClass() {
		CRUD.tearDown();
	}
}
