
package br.edu.insper.desagil.backend.core;

import java.util.List;

import br.edu.insper.desagil.backend.database.firestore.AutokeyFirestoreObject;

public class Turma extends AutokeyFirestoreObject {
	private List<String> matriculas;

	public Turma() {
	}

	public Turma(List<String> matriculas) {
		this.matriculas = matriculas;
	}

	public List<String> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<String> matriculas) {
		this.matriculas = matriculas;
	}
}