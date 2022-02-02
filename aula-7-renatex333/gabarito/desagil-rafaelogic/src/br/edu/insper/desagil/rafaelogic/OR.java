package br.edu.insper.desagil.rafaelogic;

public class OR extends PortaLogica {
	private NAND nand;

	public OR() {
		nand = new NAND();
	}

	@Override
	public boolean getSaida(boolean a, boolean b) {
		return nand.getSaida(nand.getSaida(a, a), nand.getSaida(b, b));
	}
}
