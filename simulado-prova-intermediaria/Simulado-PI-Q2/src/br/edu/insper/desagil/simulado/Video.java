package br.edu.insper.desagil.simulado;

import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

public class Video{
	private int id;
	private Usuario usuario;
	private Produto produto;
	private Map<String, Integer> avaliacoes;
	
	public Video(int id, Usuario usuario, Produto produto) {
		this.id = id;
		this.usuario = usuario;
		this.produto = produto;
		this.avaliacoes = new HashMap<>();
	}
	
	public int getId() {
		return this.id;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void adicionaAvaliacao(Usuario usuario, int avaliacao) {
		if (!this.usuario.getNome().equals(usuario.getNome()) && avaliacao >= 1 && avaliacao <= 5 ) {
			this.avaliacoes.put(usuario.getNome(), avaliacao);
		}
	}
	
	public int mediaAvaliacoes() {
		if (this.avaliacoes.size() == 0) {
			return 0;
		}
			
		double n = 0;
		for (String nome: this.avaliacoes.keySet()) {
			n += this.avaliacoes.get(nome);
		}
		double media = n/this.avaliacoes.size();
		int arredondado = (int) Math.round(media);
		return arredondado;
	}
}
