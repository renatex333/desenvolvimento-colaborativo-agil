package br.edu.insper.desagil.cooktop;

public class ItemGenerico {
	private String codigo;
	private String nome;
	
	public ItemGenerico(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
