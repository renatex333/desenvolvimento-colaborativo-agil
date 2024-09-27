package br.edu.insper.desagil.api.endpoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.api.http.EndpointTest;

class ArvoreEndpointTest extends EndpointTest<String> {
	
	@BeforeEach
	public void setUp() {
		start("http://192.168.15.39:8080/arvore");
	}

	@Test
	public void constroiPara1() {
		assertEquals(String.join("",
			"|\n",
			""
		), get("?n=1"));
	}

	@Test
	public void constroiPara2() {
		assertEquals(String.join("",
			" |\n",
			"/|\\"
		), get("?n=2"));
	}

	@Test
	public void constroiPara3() {
		assertEquals(String.join("",
			"  |\n",
			" /|\\\n",
			"//|\\\\"
		), get("?n=3"));
	}

	@Test
	public void constroiPara4() {
		assertEquals(String.join("",
			"   |\n",
			"  /|\\\n",
			" //|\\\\\n",
			"///|\\\\\\"
		), get("?n=4"));
	}

	@Test
	public void constroiPara5() {
		assertEquals(String.join("",
			"    |\n",
			"   /|\\\n",
			"  //|\\\\\n",
			" ///|\\\\\\\n",
			"////|\\\\\\\\"
		), get("?n=5"));
	}
	
	@AfterEach
	public void tearDown() {
		stop();
	}

}
