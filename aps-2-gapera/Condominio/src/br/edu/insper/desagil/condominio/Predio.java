package br.edu.insper.desagil.condominio;

import java.util.List;

public class Predio {
	private Administracao administracao;
	private List<Apartamento> apartamentos;

	public Predio(List<Apartamento> apartamentos) {
		this.administracao = new Administracao();
		this.apartamentos = apartamentos;
	}

	public Administracao getAdministracao() {
		return administracao;
	}
	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public int totalMoradores() {
		int total = 0;
		for (Apartamento apartamento: apartamentos) {
			total += apartamento.getMoradores().size();
		}
		return total;
	}
}
