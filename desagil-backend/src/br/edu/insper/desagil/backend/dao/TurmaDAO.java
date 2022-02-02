package br.edu.insper.desagil.backend.dao;

import br.edu.insper.desagil.backend.core.Turma;
import br.edu.insper.desagil.backend.database.firestore.FirestoreDAO;

public class TurmaDAO extends FirestoreDAO<Turma> {
	public TurmaDAO() {
		super("turmas");
	}
}