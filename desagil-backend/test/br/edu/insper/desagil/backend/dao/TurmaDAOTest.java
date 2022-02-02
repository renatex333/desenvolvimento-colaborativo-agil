package br.edu.insper.desagil.backend.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Turma;
import br.edu.insper.desagil.backend.database.firestore.Firestore;

class TurmaDAOTest {
	private static String name;

	private TurmaDAO dao;

	@BeforeAll
	public static void setUpClass() {
		name = Firestore.start(Backend.CREDENTIALS_TEST);
	}

	@BeforeEach
	public void setUp() {
		dao = new TurmaDAO();
		dao.deleteAll();
	}

	@Test
	public void criaUmaTurmaSemAlunos() {
		List<String> matriculas = new ArrayList<>();

		Turma turma = new Turma(matriculas);

		assertDoesNotThrow(() -> {
			dao.create(turma);
		});
	}

	@AfterAll
	public static void tearDownClass() {
		Firestore.stop(name);
	}
}