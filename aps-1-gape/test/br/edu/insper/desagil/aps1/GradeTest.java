package br.edu.insper.desagil.aps1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeTest {
	private Grade g;

	@BeforeEach
	void setUp() {
		g = new Grade();
	}

	@Test
	void constroiPara1() {
		assertEquals(String.join("",
				"+-+\n",
				"| |\n",
				"+-+\n"
				), g.constroi(1));
	}

	@Test
	void constroiPara2() {
		assertEquals(String.join("",
				"+-+-+\n",
				"| | |\n",
				"+-+-+\n",
				"| | |\n",
				"+-+-+\n"
				), g.constroi(2));
	}

	@Test
	void constroiPara3() {
		assertEquals(String.join("",
				"+-+-+-+\n",
				"| | | |\n",
				"+-+-+-+\n",
				"| | | |\n",
				"+-+-+-+\n",
				"| | | |\n",
				"+-+-+-+\n"
				), g.constroi(3));
	}

	@Test
	void constroiPara4() {
		assertEquals(String.join("",
				"+-+-+-+-+\n",
				"| | | | |\n",
				"+-+-+-+-+\n",
				"| | | | |\n",
				"+-+-+-+-+\n",
				"| | | | |\n",
				"+-+-+-+-+\n",
				"| | | | |\n",
				"+-+-+-+-+\n"
				), g.constroi(4));
	}

	@Test
	void constroiPara5() {
		assertEquals(String.join("",
				"+-+-+-+-+-+\n",
				"| | | | | |\n",
				"+-+-+-+-+-+\n",
				"| | | | | |\n",
				"+-+-+-+-+-+\n",
				"| | | | | |\n",
				"+-+-+-+-+-+\n",
				"| | | | | |\n",
				"+-+-+-+-+-+\n",
				"| | | | | |\n",
				"+-+-+-+-+-+\n"
				), g.constroi(5));
	}
}
