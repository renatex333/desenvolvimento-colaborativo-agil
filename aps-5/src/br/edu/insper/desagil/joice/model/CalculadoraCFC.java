package br.edu.insper.desagil.joice.model;

public class CalculadoraCFC extends Calculadora {

	public CalculadoraCFC(String nome) {
		super(nome);
		
	}
	@Override
	public double calcula(double peso, double raio) {
		int N=4;
		double Na=6.02214076*Math.pow(10,23);
		double volume=Math.pow((2*raio*Math.sqrt(2)*Math.pow(10, -7)),3);
		double densidade= (peso *N)/(Na*volume);
		
		return Math.round(densidade*100d)/100d;

	}

}
	

