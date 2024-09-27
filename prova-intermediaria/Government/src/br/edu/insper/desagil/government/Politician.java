package br.edu.insper.desagil.government;

import java.util.Date;

public class Politician extends Citizen {
	private double salary;
	private double tax;
	private boolean corrupt;

	public Politician(String nome, String rgNumero, Date rgData, String rgEmissor, String enderecoLogradouro, int enderecoNumero, String enderecoComplemento, String enderecoCep, double salary, double tax, boolean corrupt) {
		super(nome, rgNumero, rgData, rgEmissor, enderecoLogradouro, enderecoNumero, enderecoComplemento, enderecoCep);
		this.salary = salary;
		this.tax = tax;
		this.corrupt = corrupt;
	}

	public double getSalary() {
		if (corrupt) {
			return 2 * salary;
		} else {
			return salary;
		}
	}

	public double getTax() {
		if (corrupt) {
			return tax / 2;
		} else {
			return tax;
		}
	}
}
