package br.edu.insper.desagil.backend.core;

import br.edu.insper.desagil.backend.database.firestore.AutokeyFirestoreObject;

public class Equipamento extends AutokeyFirestoreObject {

	private String usuario;
	private String nome;	
	private String modelo;
	private Integer anoAquisicao;
	private Double horas;
	private String categoria;
	private String andar;
	
	private String setor;
	private String local;
	

	public Equipamento() {
		super();
	}

	public Equipamento(String usuario, String nome, String modelo, Integer anoAquisicao,Double horas,String categoria, String setor, String local,String andar) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.modelo = modelo;
		this.anoAquisicao = anoAquisicao;
		this.horas=horas;
		this.categoria = categoria;
		this.setor = setor;
		this.local = local;
		this.andar=andar;
	}
	
	
	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
	public String getCategoria() {
		return categoria;

	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	
	}
	public Integer getAnoAquisicao() {
		return anoAquisicao;
	}

	public void setAnoAquisicao(Integer anoAquisicao) {
		this.anoAquisicao = anoAquisicao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}