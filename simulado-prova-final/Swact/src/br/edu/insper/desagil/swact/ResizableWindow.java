package br.edu.insper.desagil.swact;

public class ResizableWindow extends Window {
	private int minWidth;
	private int maxWidth;
	private int minHeight;
	private int maxHeight;

	public ResizableWindow(int minWidth, int maxWidth, int minHeight, int maxHeight) {
		super(minWidth, minHeight);
		this.minWidth = minWidth;
		this.maxWidth = maxWidth;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}

	public int getMinWidth() {
		return this.minWidth;
	}

	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}

	public int getMaxWidth() {
		return this.maxWidth;
	}

	public void setMaxWidth(int maxWidth) {
		this.maxWidth = maxWidth;
	}

	public int getMinHeight() {
		return this.minHeight;
	}

	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}

	public int getMaxHeight() {
		return this.maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	@Override
	public void setWidth(int width) {
		if (width < this.minWidth) {
			width = this.minWidth;
		}
		if (width > this.maxWidth) {
			width = this.maxWidth;
		}
		super.setWidth(width);
	}

	@Override
	public void setHeight(int height) {
		if (height < this.minHeight) {
			height = this.minHeight;
		}
		if (height > this.maxHeight) {
			height = this.maxHeight;
		}
		super.setHeight(height);
	}
}
