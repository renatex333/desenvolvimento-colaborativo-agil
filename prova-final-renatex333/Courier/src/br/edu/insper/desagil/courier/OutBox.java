package br.edu.insper.desagil.courier;

import java.util.List;

public class OutBox extends PermanentBox {
	public OutBox(List<Email> emails) {
		super("OutBox", emails);
	}
}
