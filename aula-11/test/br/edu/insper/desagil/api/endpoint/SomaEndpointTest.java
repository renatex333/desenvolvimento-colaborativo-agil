package br.edu.insper.desagil.api.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.api.http.EndpointTest;

class SomaEndpointTest extends EndpointTest<Integer> {
	@BeforeEach
	public void setUp() {
		start("http://192.168.15.39:8080/soma");
	}

	@Test
	public void umMaisDoisIgualTres() {
		assertEquals(3, get("?a=1&b=2"));
	}

	@Test
	public void tresMaisQuatroIgualSete() {
		assertEquals(7, get("?a=3&b=4"));
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}
