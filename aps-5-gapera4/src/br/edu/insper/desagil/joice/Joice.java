package br.edu.insper.desagil.joice;

import javax.swing.JFrame;

import br.edu.insper.desagil.joice.view.View;

public class Joice {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			View view = new View();

			JFrame window = new JFrame("Joice");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setContentPane(view);
			window.setResizable(false);
			window.setVisible(true);
			window.pack();
		});
	}
}
