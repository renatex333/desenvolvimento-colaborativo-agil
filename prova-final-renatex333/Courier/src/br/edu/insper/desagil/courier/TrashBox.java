package br.edu.insper.desagil.courier;

import java.util.List;

public class TrashBox extends TemporaryBox {
	public TrashBox(List<Email> emails) {
		super("TrashBox", emails);
	}
}
