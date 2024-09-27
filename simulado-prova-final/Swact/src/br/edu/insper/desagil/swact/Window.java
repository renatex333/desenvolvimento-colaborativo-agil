package br.edu.insper.desagil.swact;

public class Window {
	private int width;
	private int height;
	private Component panel;

	public Window(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Component getPanel() {
		return this.panel;
	}

	public void setPanel(Component panel) {
		this.panel = panel;
	}
}
