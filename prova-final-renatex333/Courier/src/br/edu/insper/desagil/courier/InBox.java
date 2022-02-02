package br.edu.insper.desagil.courier;

import java.util.List;

public class InBox extends PermanentBox {
	public InBox(List<Email> emails) {
		super("InBox", emails);
	}
}
