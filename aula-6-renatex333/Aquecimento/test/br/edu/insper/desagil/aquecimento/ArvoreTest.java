package br.edu.insper.desagil.aquecimento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.aquecimento.Arvore;

class ArvoreTest {
	private Arvore a;

	@BeforeEach
	private void setUp() {
		a = new Arvore();
	}

	@Test
	public void constroiPara1() {
		assertEquals(String.join("",
			"|\n"
		), a.constroi(1));
	}

	@Test
	public void constroiPara2() {
		assertEquals(String.join("",
			" |\n",
			"/|\\\n"
		), a.constroi(2));
	}

	@Test
	public void constroiPara3() {
		assertEquals(String.join("",
			"  |\n",
			" /|\\\n",
			"//|\\\\\n"
		), a.constroi(3));
	}

	@Test
	public void constroiPara4() {
		assertEquals(String.join("",
			"   |\n",
			"  /|\\\n",
			" //|\\\\\n",
			"///|\\\\\\\n"
		), a.constroi(4));
	}

	@Test
	public void constroiPara5() {
		assertEquals(String.join("",
			"    |\n",
			"   /|\\\n",
			"  //|\\\\\n",
			" ///|\\\\\\\n",
			"////|\\\\\\\\\n"
		), a.constroi(5));
	}
}
