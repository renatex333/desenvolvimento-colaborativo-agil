package br.edu.insper.desagil.derp;

import java.util.ArrayList;
import java.util.List;

public class Log {
	private List<String> entries;

	public Log() {
		this.entries = new ArrayList<>();
	}

	public boolean contains(String entry) {
		return this.entries.contains(entry);
	}

	public int size() {
		return this.entries.size();
	}

	public void add(String entry) {
		this.entries.add(entry);
	}
}
