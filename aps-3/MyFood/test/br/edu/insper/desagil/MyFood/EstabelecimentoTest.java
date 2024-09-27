package br.edu.insper.desagil.MyFood;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EstabelecimentoTest {
	private List<Integer> pedido;
	private Estabelecimento estabelecimento;

	@BeforeEach
	public void setUp() {
		estabelecimento = new Estabelecimento("McDonalds");
		pedido = new ArrayList<>();
	}

	@Test
	public void processaDoisTest() {
		ItemComum item1 = new ItemComum("batata", 5.0);
		ItemComum item2 = new ItemComum("hamburguer", 15.0);
		ItemComum item3 = new ItemComum("coca", 3.5);

		estabelecimento.cadastra(1, item1);
		estabelecimento.cadastra(2, item2);
		estabelecimento.cadastra(3, item3);

		pedido.add(1);
		pedido.add(2);

		assertEquals(20.0, estabelecimento.processa(pedido), 0.01);

	}

	@Test
	public void processaDoisComunsEUmComboTest() {
		ItemComum item1 = new ItemComum("batata", 5.0);
		ItemComum item2 = new ItemComum("hamburguer", 15.0);
		ItemComum item3 = new ItemComum("coca", 3.5);
		List<ItemComum> listacombo = new ArrayList<>();
		listacombo.add(item1);
		listacombo.add(item2);
		listacombo.add(item3);
		ItemCombo itemcombo = new ItemCombo("combo", 0.9, listacombo);
		
		estabelecimento.cadastra(1, item1);
		estabelecimento.cadastra(2, item2);
		estabelecimento.cadastra(3, itemcombo);
		
		pedido.add(1);
		pedido.add(2);
		pedido.add(3);
		
		assertEquals(41.15, estabelecimento.processa(pedido), 0.01);
	
	}

	@Test
	public void processaUmComumEDoisCombosTest() {
		ItemComum item1 = new ItemComum("batata", 5.0);
		ItemComum item2 = new ItemComum("hamburguer", 15.0);
		ItemComum item3 = new ItemComum("coca", 3.5);
		ItemComum item4 = new ItemComum("nuggets", 5.5);
		
		List<ItemComum> listacombo1 = new ArrayList<>();
		listacombo1.add(item2);
		listacombo1.add(item3);
		listacombo1.add(item4);
		ItemCombo itemcombo1 = new ItemCombo("combo", 0.8, listacombo1);
		
		List<ItemComum> listacombo2 = new ArrayList<>();
		listacombo2.add(item1);
		listacombo2.add(item2);
		listacombo2.add(item3);
		ItemCombo itemcombo2 = new ItemCombo("combo", 0.9, listacombo2);
		
		estabelecimento.cadastra(1, item1);
		estabelecimento.cadastra(2, itemcombo1);
		estabelecimento.cadastra(3, itemcombo2);
		
		pedido.add(1);
		pedido.add(2);
		pedido.add(3);
		
		assertEquals(45.35, estabelecimento.processa(pedido), 0.01);
		
	}
}