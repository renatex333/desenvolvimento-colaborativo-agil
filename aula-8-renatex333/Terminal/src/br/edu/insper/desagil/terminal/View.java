package br.edu.insper.desagil.terminal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class View extends JPanel implements DocumentListener, ActionListener{
	private static final long serialVersionUID = 1L;

	private JTextArea area;
	private JTextField field;
	private JButton button;
	private JLabel label;

	public View() {
		super();

		this.area = new JTextArea();
		this.area.setEditable(false);
		this.area.setBackground(Color.BLACK);
		this.area.setForeground(Color.GREEN);

		this.field = new JTextField();
		this.field.getDocument().addDocumentListener(this);

		this.button = new JButton("Post");
		this.button.addActionListener(this);

		this.label = new JLabel();

		JScrollPane scroll = new JScrollPane(this.area);

		this.add(scroll);
		this.add(this.field);
		this.add(this.button);
		this.add(this.label);

		SpringLayout layout = new SpringLayout();

		layout.putConstraint(SpringLayout.WEST, scroll, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scroll, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, scroll, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, scroll, -5, SpringLayout.NORTH, this.button);

		layout.putConstraint(SpringLayout.WEST, this.field, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, this.field, 0, SpringLayout.NORTH, this.button);
		layout.putConstraint(SpringLayout.SOUTH, this.field, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, this.field, -5, SpringLayout.WEST, this.button);

		layout.putConstraint(SpringLayout.SOUTH, this.button, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, this.button, -10, SpringLayout.WEST, this.label);

		layout.putConstraint(SpringLayout.SOUTH, this.label, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, this.label, -10, SpringLayout.EAST, this);

		this.setPreferredSize(new Dimension(640, 480));
		this.setLayout(layout);

		updateLabel();
		
	}

	private void updateArea() {
		String text = this.field.getText();
		if (!text.isBlank()) {
			this.area.setText(this.area.getText() + text + '\n');
			this.field.setText("");
		}
	}

	private void updateLabel() {
		int count = this.field.getText().length();
		this.label.setText(Integer.toString(count));
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		updateArea();
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		updateArea();
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		updateArea();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateArea();
		
	}

}
