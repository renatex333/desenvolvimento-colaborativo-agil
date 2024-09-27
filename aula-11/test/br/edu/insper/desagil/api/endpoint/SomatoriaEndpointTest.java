package br.edu.insper.desagil.api.endpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.api.http.EndpointTest;

class SomatoriaEndpointTest extends EndpointTest<Integer> {
	@BeforeEach
	public void setUp() {
		start("http://192.168.15.39:8080/somatoria");
	}

	@Test
	public void umDoisTresQuatroIgualDez() {
		assertEquals(10, get("?l=1,2,3,4"));
	}

	@AfterEach
	public void tearDown() {
		stop();
	}
}
