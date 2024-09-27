package br.edu.insper.desagil.joice.model;

public class CalculadoraCCC extends Calculadora{

	public CalculadoraCCC(String nome) {
		super(nome);
		
	}
	@Override
	public double calcula(double peso, double raio) {
		int N=2;
		double Na=6.02214076*Math.pow(10,23);
		double volume=Math.pow((4*raio*Math.pow(10, -7)/Math.sqrt(3)),3);
		double densidade= (peso *N)/(Na*volume);
		
	return Math.round(densidade*100d)/100d;
}
}