package br.edu.insper.desagil.joice.model.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import br.edu.insper.desagil.joice.model.CalculadoraCFC;

public class CalculadoraCFCtest {
	private CalculadoraCFC cfc=new CalculadoraCFC("Cubica de Face Centrada");
	
	
	  @Test
	  public void Cobre() {
		  assertEquals(8.9,cfc.calcula(63.55,0.128),0.05);
	  }
	  @Test
	  public void Ouro() {
		  assertEquals(19.36,cfc.calcula(196.97,0.144),0.05);
	  }
	  @Test
	  public void Prata() {
		  assertEquals(10.6,cfc.calcula(107.87,0.144),0.05);
	  }
}
