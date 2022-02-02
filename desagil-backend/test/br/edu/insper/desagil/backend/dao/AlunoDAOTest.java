package br.edu.insper.desagil.backend.dao;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Aluno;
import br.edu.insper.desagil.backend.database.firestore.Firestore;

class AlunoDAOTest {
	private static String name;

	private AlunoDAO dao;

	@BeforeAll
	public static void setUpClass() {
		name = Firestore.start(Backend.CREDENTIALS_TEST);
	}

	@BeforeEach
	public void setUp() {
		dao = new AlunoDAO();
		dao.deleteAll();
	}

	@Test
	public void criaQuatroAlunosDiferentes() {
		Aluno aluno1 = new Aluno(1, "Maria", true, 4.5);
		Aluno aluno2 = new Aluno(2, "José", false, 10.0);
		Aluno aluno3 = new Aluno(3, "Mariana", true, 5.5);
		Aluno aluno4 = new Aluno(4, "João", false, 0.0);

		assertDoesNotThrow(() -> {
			dao.create(aluno1);
			dao.create(aluno2);
			dao.create(aluno3);
			dao.create(aluno4);
		});
	}

	@AfterAll
	public static void tearDownClass() {
		Firestore.stop(name);
	}
}