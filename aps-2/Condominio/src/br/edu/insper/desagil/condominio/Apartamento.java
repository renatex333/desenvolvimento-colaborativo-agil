package br.edu.insper.desagil.condominio;

import java.util.ArrayList;
import java.util.List;

public class Apartamento {
	private int numero;
	private List<Pessoa> moradores;

	public Apartamento(int numero) {
		this.numero = numero;
		this.moradores = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}
	public List<Pessoa> getMoradores() {
		return moradores;
	}

	public void adicionaMorador(Pessoa pessoa) {
		moradores.add(pessoa);
	}
}
