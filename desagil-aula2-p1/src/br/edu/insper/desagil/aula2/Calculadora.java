package br.edu.insper.desagil.aula2;

public class Calculadora {

	public double executa(int a, int b, char op) {
		double c = 0.0;
		
		if (op == '+') {
			c = a+b;
			
		} else if (op == '-') {
			c = a-b;
			
		} else if (op == '*') {
			c = a*b;
			
		} else if (op == '/') {
			c = (double)a/b;
			
		}
		return c;
	}

}
