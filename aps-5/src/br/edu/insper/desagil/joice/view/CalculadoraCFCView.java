package br.edu.insper.desagil.joice.view;

import br.edu.insper.desagil.joice.model.CalculadoraCFC;

public class CalculadoraCFCView extends CalculadoraView {
	public CalculadoraCFCView() {
		super(new CalculadoraCFC("Cubica de Face Centrada"), "CFC");
	}
}
