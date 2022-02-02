package br.edu.insper.desagil.crud.dao;

import br.edu.insper.desagil.crud.Aluno;
import br.edu.insper.desagil.crud.database.firestore.FirestoreDAO;

public class AlunoDAO extends FirestoreDAO<Aluno> {
	public AlunoDAO() {
		super("alunos");
	}
}
