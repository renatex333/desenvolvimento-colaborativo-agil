package br.edu.desagil.aula7;

public class Xor extends PortaLogica{
	@Override
	public boolean getSaida(boolean a, boolean b) {
		return ((a && !b) || (!a && b));
	}
}
