package br.edu.insper.desagil.rafaelogic;

public class XOR extends PortaLogica {
	private NAND nand;

	public XOR() {
		nand = new NAND();
	}

	@Override
	public boolean getSaida(boolean a, boolean b) {
		return nand.getSaida(nand.getSaida(a, nand.getSaida(a, b)), nand.getSaida(nand.getSaida(a, b), b));
	}
}
