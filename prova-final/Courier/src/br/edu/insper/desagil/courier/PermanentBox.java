package br.edu.insper.desagil.courier;

import java.util.List;

public abstract class PermanentBox extends Box {
	public PermanentBox(String name, List<Email> emails) {
		super(name, emails);
	}

	public void archive(Email email) {
	}
}
