package br.edu.insper.desagil.backend.dao;

import br.edu.insper.desagil.backend.core.Equipamento;
import br.edu.insper.desagil.backend.database.firestore.FirestoreDAO;

public class EquipamentoDAO extends FirestoreDAO<Equipamento> {
	
	public EquipamentoDAO() {
		super("equipamentos");
	}
}
