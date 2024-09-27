package br.edu.insper.desagil.backend.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalTime;
public class EquipamentoTest {
	private Equipamento equipamento;
	
	@BeforeEach
	void setUp() {
		equipamento = new Equipamento();
	}

	@Test
	void test() {
		equipamento.setNome("Britadeira");
		equipamento.setUsuario("Leandro");
		//equipamento.setHoras("19:08:56.635430").toString();
		equipamento.setModelo("Britadeira de 5 Kilos");
		
		assertEquals("Britadeira", equipamento.getNome());
		assertEquals("Leandro", equipamento.getUsuario());
		//assertEquals(19:08:56.635430, equipamento.getHoras());
		assertEquals("Britadeira de 5 Kilos", equipamento.getModelo());
	}
}
