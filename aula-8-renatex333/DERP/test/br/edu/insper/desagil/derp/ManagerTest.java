package br.edu.insper.desagil.derp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ManagerTest {
	@Test
	public void test() {
		Log log = new Log();
		BD bd = new BD(log);
		GUI gui = new GUI(log);
		API api = new API(log);
		Manager manager = new Manager();
		manager.addReportHandler(bd);
		manager.addReportHandler(gui);
		manager.addReportHandler(api);
		Report report = new Report("Balanço Financeiro");

		manager.finish(report);

		assertEquals(3, log.size());
		assertTrue(log.contains("BD saved Balanço Financeiro"));
		assertTrue(log.contains("GUI showed Balanço Financeiro"));
		assertTrue(log.contains("API notified Balanço Financeiro"));
	}
}
