package br.edu.insper.desagil.api.endpoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.api.http.EndpointTest;

class BissextoEndpointTest extends EndpointTest<Integer> {
	@BeforeEach
	public void setUp() {
		start("http://192.168.15.39:8080/bissexto");
	}

	@Test
	public void simbissexto() {
		assertEquals("É bissexto", get("?ano=2016"));
	}

	@Test
	public void naobissexto() {
		assertEquals("Não é bissexto", get("?ano=2013"));
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}
