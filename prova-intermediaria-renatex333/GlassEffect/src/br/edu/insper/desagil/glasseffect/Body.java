package br.edu.insper.desagil.glasseffect;

public abstract class Body {
	private String name;
	private Vector position;

	public Body(String name, Vector position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector position) {
		this.position = position;
	}
}
