package br.edu.insper.desagil.backend.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.insper.desagil.backend.Backend;
import br.edu.insper.desagil.backend.core.Equipamento;
import br.edu.insper.desagil.backend.database.firestore.Firestore;

public class EquipamentoDAOTest {

	private static String name;

	private EquipamentoDAO dao;

	@BeforeAll
	public static void setUpClass() {
		name = Firestore.start(Backend.CREDENTIALS_TEST);
	}

	@BeforeEach
	public void setUp() {
		dao = new EquipamentoDAO();
		dao.deleteAll();
	}

	@Test
	public void criaEquipamento() {
		Equipamento equipamento;
		equipamento = new Equipamento();
		equipamento.setUsuario("Leandro");
		dao.create(equipamento);
		String key = equipamento.getKey();
		equipamento = dao.retrieve(key);
		assertEquals("Leandro", equipamento.getUsuario());
	}
	
	@Test
	public void criaEquipamentoEAtualiza() {
		Equipamento equipamento;
		equipamento = new Equipamento();
		equipamento.setUsuario("Leandro");
		dao.create(equipamento);
		String key = equipamento.getKey();

		equipamento.setUsuario("Felipe");
		dao.update(equipamento);
		
		equipamento = dao.retrieve(key);
		
		assertEquals("Felipe", equipamento.getUsuario());
	}

	@Test
	public void criaEquipamentoEDeleta() {
		Equipamento equipamento;
		equipamento = new Equipamento();
		dao.create(equipamento);
		String key = equipamento.getKey();
		
		dao.delete(key);

	    assertEquals(false, dao.exists(key));

	}
	
	@AfterAll
	public static void tearDownClass() {
		Firestore.stop(name);
	}
}
