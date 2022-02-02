package br.edu.insper.desagil.blackbeard.model.base;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	private String codigo;
	private String nome;
	private List<String> ementa;

	public Disciplina(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = new ArrayList<>();
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public List<String> getEmenta() {
		return this.ementa;
	}

	public String toString() {
		return this.codigo + ": " + this.nome;
	}
}
