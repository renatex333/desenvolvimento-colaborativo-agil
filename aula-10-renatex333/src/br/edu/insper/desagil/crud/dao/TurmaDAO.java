package br.edu.insper.desagil.crud.dao;

import br.edu.insper.desagil.crud.Turma;
import br.edu.insper.desagil.crud.database.firestore.FirestoreDAO;

public class TurmaDAO extends FirestoreDAO<Turma> {
	public TurmaDAO() {
		super("turmas");
	}
}
