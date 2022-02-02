package br.edu.insper.desagil.tinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gerenciador {
	private Map<Integer, Perfil> perfis;
	
	public Gerenciador() {
		this.perfis = new HashMap<>();
	}
	
	public Perfil cadastraPerfil(int id, String nome) {
		Perfil perfil = new Perfil(id, nome, this);
		this.perfis.put(id, perfil);
		return perfil;
	}
	
	public PerfilPremium cadastraPerfilPremium(int id, String nome) {
		PerfilPremium perfil = new PerfilPremium(id, nome, this);
		this.perfis.put(id, perfil);
		return perfil;	
	}
	
	public void atualizaCombinacoes(Perfil a, Perfil b) {
		if (b.curtiu(a)) {
			a.combina(b);
			b.combina(a);
		}
	}
	
	public List<Perfil> quemCurtiu(Perfil perfil) {
		List<Perfil> lista = new ArrayList<>();
		for (int id: this.perfis.keySet()) {
			if (this.perfis.get(id).curtiu(perfil)) {
				lista.add(perfil);
			}
		}
		
		return lista;
	}
}
