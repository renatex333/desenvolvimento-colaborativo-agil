package br.edu.insper.desagil.api.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.api.http.EndpointTest;

class QuocienteEndpointTest extends EndpointTest<Double> {
	private static final double DELTA = 0.000001;

	@BeforeEach
	public void setUp() {
		start("http://192.168.15.39:8080/quociente");
	}

	@Test
	public void cincoPorDoisIgualDoisMeio() {
		assertEquals(2.5, get("?a=5&b=2"), DELTA);
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}
