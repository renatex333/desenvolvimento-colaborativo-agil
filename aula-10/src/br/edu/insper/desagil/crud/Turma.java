package br.edu.insper.desagil.crud;

import java.util.List;

import br.edu.insper.desagil.crud.database.firestore.AutokeyFirestoreObject;

public class Turma extends AutokeyFirestoreObject {
	private List<String> matriculas;

	public Turma(List<String> matriculas) {
		this.matriculas = matriculas;
	}
	
	public Turma() {
		
	}

	public List<String> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<String> matriculas) {
		this.matriculas = matriculas;
	}
}
