package br.edu.insper.desagil.rafaelogic;

public class AND extends PortaLogica {
	private NAND nand;

	public AND() {
		nand = new NAND();
	}

	@Override
	public boolean getSaida(boolean a, boolean b) {
		return nand.getSaida(nand.getSaida(a, b), nand.getSaida(a, b));
	}
}
