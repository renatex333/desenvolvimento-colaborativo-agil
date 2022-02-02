package br.edu.insper.desagil.rafaelogic;

public class NAND extends PortaLogica {
	@Override
	public boolean getSaida(boolean a, boolean b) {
		return !(a && b);
	}
}
