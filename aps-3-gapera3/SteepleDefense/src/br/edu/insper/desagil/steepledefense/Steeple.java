package br.edu.insper.desagil.steepledefense;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Steeple extends Element {
	private List<Defender> defenders;

	public Steeple(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.defenders = new ArrayList<>();
	}

	public List<Defender> getDefenders() {
		return Collections.unmodifiableList(this.defenders);
	}

	public void add(Defender defender) {
		this.defenders.add(defender);
	}
}
