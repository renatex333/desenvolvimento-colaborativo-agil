package br.edu.insper.desagil.terminal;

import javax.swing.JFrame;

public class Terminal {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			View view = new View();

			JFrame window = new JFrame("Terminal");
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setContentPane(view);
			window.setResizable(false);
			window.setVisible(true);
			window.pack();
		});
	}
}
