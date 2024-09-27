package br.edu.insper.desagil.courier;

import java.util.List;

public abstract class TemporaryBox extends Box {
	public TemporaryBox(String name, List<Email> emails) {
		super(name, emails);
	}

	public void clear() {
	}
}
