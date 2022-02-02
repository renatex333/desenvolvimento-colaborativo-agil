package br.edu.insper.desagil.government;

import java.util.Date;

public class Citizen {
	private String nome;
	private String rgNumero;
	private Date rgData;
	private String rgEmissor;
	private String enderecoLogradouro;
	private int enderecoNumero;
	private String enderecoComplemento;
	private String enderecoCep;

	public Citizen(String nome, String rgNumero, Date rgData, String rgEmissor, String enderecoLogradouro, int enderecoNumero, String enderecoComplemento, String enderecoCep) {
		this.nome = nome;
		this.rgNumero = rgNumero;
		this.rgData = rgData;
		this.rgEmissor = rgEmissor;
		this.enderecoLogradouro = enderecoLogradouro;
		this.enderecoNumero = enderecoNumero;
		this.enderecoComplemento = enderecoComplemento;
		this.enderecoCep = enderecoCep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRgNumero() {
		return rgNumero;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}

	public Date getRgData() {
		return rgData;
	}

	public void setRgData(Date rgData) {
		this.rgData = rgData;
	}

	public String getRgEmissor() {
		return rgEmissor;
	}

	public void setRgEmissor(String rgEmissor) {
		this.rgEmissor = rgEmissor;
	}

	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public int getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(int enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(String enderecoCep) {
		this.enderecoCep = enderecoCep;
	}
}
