package br.edu.insper.desagil.tinder;

import java.util.ArrayList;
import java.util.List;

public class Perfil {
	private int id;
	private String nome;
	private Gerenciador gerenciador;
	private List<Integer> curtidas;
	private List<Integer> combinacoes;

	public Perfil(int id, String nome, Gerenciador gerenciador) {
		this.id = id;
		this.nome = nome;
		this.gerenciador = gerenciador;
		this.curtidas = new ArrayList<>();
		this.combinacoes = new ArrayList<>();
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean curtiu(Perfil perfil) {
		if (this.curtidas.contains(perfil.getId())) {
			return true;
		} else {
			return false;
		}
		
	}
	public void curte(Perfil perfil) {
		this.curtidas.add(perfil.getId());
		this.gerenciador.atualizaCombinacoes(this, perfil);
	}
	public boolean combinou(Perfil perfil) {
		if (this.combinacoes.contains(perfil.getId())) {
			return true;
		} else {
			return false;
		}
	}
	public void combina(Perfil perfil) {
		this.combinacoes.add(perfil.getId());
	}
	public boolean autoriza() {
		return false;
	}
	public List<Perfil> quemCurtiu() {
		if (this.autoriza()) {
			return this.gerenciador.quemCurtiu(this);
		} else {
			return null;
		}
		
	}
	
}
