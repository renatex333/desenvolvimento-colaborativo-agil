package br.edu.insper.desagil.joice.model.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


import br.edu.insper.desagil.joice.model.CalculadoraCCC;

public class CalculadoraCCCtest {
	private CalculadoraCCC ccc=new CalculadoraCCC("Cubica de Corpo Centrado");
	
	
	@Test
	public void Niobio() {
		  assertEquals(8.57,ccc.calcula(92.91,0.143),0.05);
	  }
	@Test
	public void Litio() {
		  assertEquals(0.53,ccc.calcula(6.94,0.152),0.05);
	  }
	@Test
	public void Tungstenio() {
		  assertEquals(19.28,ccc.calcula(183.84,0.137),0.05);
	  }
}
