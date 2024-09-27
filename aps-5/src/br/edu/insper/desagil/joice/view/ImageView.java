package br.edu.insper.desagil.joice.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.JPanel;

public class ImageView extends JPanel {
	private static final long serialVersionUID = 1L;

	private static int WIDTH = 266;
	private static int HEIGHT = 240;

	private Image image;

	public ImageView() {
		super();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	public void updateImage(String name) {
		URL url = getClass().getClassLoader().getResource(name + ".png");
		this.image = getToolkit().getImage(url);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.image, 0, 0, WIDTH, HEIGHT, this);
		getToolkit().sync();
	}
}
