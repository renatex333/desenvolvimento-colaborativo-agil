package br.edu.insper.desagil.aquecimento;

public class Calculadora {

	public double executa(int a, char op, int b) {
		double r;

		switch (op) {
		case '+':
			r = a + b;
			break;
		case '-':
			r = a - b;
			break;
		case '*':
			r = a * b;
			break;
		default:
			if (b == 0) {
				r = 0.0;
			} else {
				r = (double) a / b;
			}
			break;
		}

		return r;
	}

}
