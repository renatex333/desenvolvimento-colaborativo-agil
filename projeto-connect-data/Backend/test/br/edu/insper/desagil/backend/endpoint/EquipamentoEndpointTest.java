package br.edu.insper.desagil.backend.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.core.Equipamento;
import br.edu.insper.desagil.backend.httpserver.EndpointTest;
import br.edu.insper.desagil.backend.httpserver.Result;

public class EquipamentoEndpointTest extends EndpointTest<Equipamento> {

	
	@BeforeEach
	public void setUp() {
		start("http://localhost:8000", "/equipamento");
		deleteList();
	}

	@Test
	public void test() {
		Equipamento equipamento;
		equipamento = new Equipamento();
		equipamento.setUsuario("Leandro");
		Result result = post(equipamento);
		String key = (String) result.get("key");
		equipamento = get("key=" + key);
		assertEquals("Leandro", equipamento.getUsuario());
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}
