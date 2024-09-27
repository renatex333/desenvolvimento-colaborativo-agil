package br.edu.insper.desagil.steepledefense;

public abstract class Element {
	private int x;
	private int y;
	private int width;
	private int height;

	public Element(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return this.x;
	}
	protected void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	protected void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
}
