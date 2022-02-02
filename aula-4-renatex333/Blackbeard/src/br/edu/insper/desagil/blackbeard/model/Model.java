package br.edu.insper.desagil.blackbeard.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.insper.desagil.blackbeard.model.base.Aluno;
import br.edu.insper.desagil.blackbeard.model.base.Disciplina;
import br.edu.insper.desagil.blackbeard.model.base.Matricula;
import br.edu.insper.desagil.blackbeard.model.base.Oferecimento;

public class Model {
	private List<Aluno> alunos;
	private List<Disciplina> disciplinas;
	private List<Oferecimento> oferecimentos;

	private List<AlunoListener> alunoListeners;
	private List<DisciplinaListener> disciplinaListeners;
	private List<OferecimentoListener> oferecimentoListeners;
	private List<MatriculaListener> matriculaListeners;

	public Model() {
		this.alunos = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
		this.oferecimentos = new ArrayList<>();

		this.alunoListeners = new ArrayList<>();
		this.disciplinaListeners = new ArrayList<>();
		this.oferecimentoListeners = new ArrayList<>();
		this.matriculaListeners = new ArrayList<>();
	}

	/*
	 *
	 * VOCÊ NÃO PRECISA ENTENDER NADA ACIMA
	 * (exceto as três primeiras listas)
	 *
	 */

	public Aluno adicionaAluno(int id, String nome) {
		Aluno aluno = null;
		if (id >= 0 && !nome.isBlank()) {
			for (Aluno existente: this.alunos) {
				if (existente.getId() == id) {
					return null;
				}
			}
			aluno = new Aluno(id, nome);
			this.alunos.add(aluno);
		}
		return aluno;
	}

	public Disciplina adicionaDisciplina(String codigo, String nome) {
		List<String> ementa = new ArrayList<>();
		Disciplina disciplina = null;
		if (!codigo.isBlank() && !nome.isBlank()) {
			for (Disciplina existente: this.disciplinas) {
	            if (existente.getCodigo().equals(codigo)) {
	                return null;
	            }
			}
			disciplina = new Disciplina(codigo, nome, ementa);
			this.disciplinas.add(disciplina);
		}
		return disciplina;
	}

	public Oferecimento adicionaOferecimento(Disciplina disciplina) {
		Oferecimento oferecimento = null;
		if (disciplina != null) {
			Map<Date, String> plano = new HashMap<>();
			List<Matricula> matriculas= new ArrayList<>();
			oferecimento = new Oferecimento(disciplina, plano, matriculas);
			this.oferecimentos.add(oferecimento);
		}
		return oferecimento;
	}

	public Oferecimento adicionaMatricula(Aluno aluno, int i) {
		Oferecimento oferecimento = null;
		if (aluno != null && i >= 0) {
			oferecimento = this.oferecimentos.get(i);
			List<Matricula> matriculas = oferecimento.getMatriculas();
			for (Matricula existente: matriculas) {
	            if (existente.getAluno().getId() == aluno.getId()) {
	                return null;
	            }
	        }
			Matricula matricula = new Matricula(aluno, false);
			oferecimento.getMatriculas().add(matricula);
		}
		return oferecimento;
	}

	/*
	 *
	 * VOCÊ NÃO PRECISA ENTENDER NADA ABAIXO.
	 *
	 */

	public void doAdicionaAluno(int id, String nome) {
		Aluno aluno = adicionaAluno(id, nome);
		if (aluno != null) {
			for (AlunoListener listener: this.alunoListeners) {
				listener.adicionou(aluno);
			}
		}
	}

	public void doAdicionaDisciplina(String codigo, String nome) {
		Disciplina disciplina = adicionaDisciplina(codigo, nome);
		if (disciplina != null) {
			for (DisciplinaListener listener: this.disciplinaListeners) {
				listener.adicionou(disciplina);
			}
		}
	}

	public void doAdicionaOferecimento(Disciplina disciplina) {
		Oferecimento oferecimento = adicionaOferecimento(disciplina);
		if (oferecimento != null) {
			for (OferecimentoListener listener: this.oferecimentoListeners) {
				listener.adicionou(oferecimento);
			}
		}
	}

	public void doAdicionaMatricula(Aluno aluno, int index) {
		Oferecimento oferecimento = adicionaMatricula(aluno, index);
		if (oferecimento != null) {
			for (MatriculaListener listener: this.matriculaListeners) {
				listener.matriculou(aluno, index + 1);
			}
		}
	}

	public void addAlunoListener(AlunoListener listener) {
		this.alunoListeners.add(listener);
	}

	public void addDisciplinaListener(DisciplinaListener listener) {
		this.disciplinaListeners.add(listener);
	}

	public void addOferecimentoListener(OferecimentoListener listener) {
		this.oferecimentoListeners.add(listener);
	}

	public void addMatriculaListener(MatriculaListener listener) {
		this.matriculaListeners.add(listener);
	}
}
