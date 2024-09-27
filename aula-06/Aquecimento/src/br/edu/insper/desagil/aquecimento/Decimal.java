package br.edu.insper.desagil.aquecimento;

public class Decimal {

	public double converte(String codigo) {
		char hA = codigo.charAt(0);
		int dA = converteDigito(hA);
		char hB = codigo.charAt(1);
		int dB = converteDigito(hB);
		return 10 * dA + dB;
	}

	public int converteDigito(char h) {
		int d;
		switch (h) {
		case '9':
			d = 9;
			break;
		case '8':
			d = 8;
			break;
		case '7':
			d = 7;
			break;
		case '6':
			d = 6;
			break;
		case '5':
			d = 5;
			break;
		case '4':
			d = 4;
			break;
		case '3':
			d = 3;
			break;
		case '2':
			d = 2;
			break;
		case '1':
			d = 1;
			break;
		default:
			d = 0;
			break;
		}
		return d;
	}

}
