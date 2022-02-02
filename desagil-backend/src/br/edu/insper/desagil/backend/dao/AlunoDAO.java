package br.edu.insper.desagil.backend.dao;

import br.edu.insper.desagil.backend.core.Aluno;
import br.edu.insper.desagil.backend.database.firestore.FirestoreDAO;

public class AlunoDAO extends FirestoreDAO<Aluno> {
	public AlunoDAO() {
		super("alunos");
	}
}