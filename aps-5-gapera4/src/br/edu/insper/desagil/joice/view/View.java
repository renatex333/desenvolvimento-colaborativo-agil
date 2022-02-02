package br.edu.insper.desagil.joice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import br.edu.insper.desagil.joice.model.Calculadora;

public class View extends JPanel implements ActionListener, DocumentListener {
	private static final long serialVersionUID = 1L;

	private Calculadora calculadora;

	private JComboBox<CalculadoraView> comboBox;
	private ImageView imageView;
	private JTextField fieldPeso;
	private JTextField fieldRaio;
	private JLabel fieldDensidade;

	public View() {
		super();

		this.comboBox = new JComboBox<>();
		this.comboBox.addItem(new CalculadoraCFCView());
		this.comboBox.addItem(new CalculadoraCCCView());
		this.comboBox.addActionListener(this);

		this.imageView = new ImageView();

		JLabel labelPeso = new JLabel("Peso:");
		JLabel labelRaio = new JLabel("Raio:");
		JLabel labelDensidade = new JLabel("Densidade:");

		this.fieldPeso = new JTextField();
		this.fieldPeso.getDocument().addDocumentListener(this);
		this.fieldRaio = new JTextField();
		this.fieldRaio.getDocument().addDocumentListener(this);
		this.fieldDensidade = new JLabel();

		SpringLayout layout = new SpringLayout();

		JPanel form = new JPanel();
		form.setLayout(layout);
		form.add(labelPeso);
		form.add(fieldPeso);
		form.add(labelRaio);
		form.add(fieldRaio);
		form.add(labelDensidade);
		form.add(fieldDensidade);

		layout.putConstraint(SpringLayout.WEST, labelPeso, 5, SpringLayout.WEST, form);
		layout.putConstraint(SpringLayout.NORTH, labelPeso, 5, SpringLayout.NORTH, form);
		layout.putConstraint(SpringLayout.EAST, labelPeso, 0, SpringLayout.EAST, labelDensidade);
		layout.putConstraint(SpringLayout.SOUTH, labelPeso, 0, SpringLayout.SOUTH, this.fieldPeso);

		layout.putConstraint(SpringLayout.WEST, labelRaio, 5, SpringLayout.WEST, form);
		layout.putConstraint(SpringLayout.NORTH, labelRaio, 5, SpringLayout.SOUTH, labelPeso);
		layout.putConstraint(SpringLayout.EAST, labelRaio, 0, SpringLayout.EAST, labelDensidade);
		layout.putConstraint(SpringLayout.SOUTH, labelRaio, 0, SpringLayout.SOUTH, this.fieldRaio);

		layout.putConstraint(SpringLayout.WEST, labelDensidade, 5, SpringLayout.WEST, form);
		layout.putConstraint(SpringLayout.NORTH, labelDensidade, 10, SpringLayout.SOUTH, labelRaio);

		layout.putConstraint(SpringLayout.WEST, this.fieldPeso, 5, SpringLayout.EAST, labelPeso);
		layout.putConstraint(SpringLayout.NORTH, this.fieldPeso, 5, SpringLayout.NORTH, form);

		layout.putConstraint(SpringLayout.WEST, this.fieldRaio, 5, SpringLayout.EAST, labelRaio);
		layout.putConstraint(SpringLayout.NORTH, this.fieldRaio, 5, SpringLayout.SOUTH, this.fieldPeso);

		layout.putConstraint(SpringLayout.WEST, this.fieldDensidade, 5, SpringLayout.EAST, labelDensidade);
		layout.putConstraint(SpringLayout.NORTH, this.fieldDensidade, 10, SpringLayout.SOUTH, this.fieldRaio);

		layout.putConstraint(SpringLayout.EAST, form, 5, SpringLayout.EAST, this.fieldPeso);
		layout.putConstraint(SpringLayout.EAST, this.fieldRaio, 0, SpringLayout.EAST, this.fieldPeso);
		layout.putConstraint(SpringLayout.EAST, this.fieldDensidade, 0, SpringLayout.EAST, this.fieldRaio);
		layout.putConstraint(SpringLayout.SOUTH, form, 15, SpringLayout.SOUTH, this.fieldDensidade);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(this.comboBox);
		add(this.imageView);
		add(form);

		atualizaCalculadora();
	}

	private void atualizaDensidade() {
		String text;
		try {
			double peso = Double.parseDouble(this.fieldPeso.getText());
			double raio = Double.parseDouble(this.fieldRaio.getText());
			text = Double.toString(this.calculadora.calcula(peso, raio));
		} catch (NumberFormatException exception) {
			text = "?";
		}
		this.fieldDensidade.setText(text);
	}

	private void atualizaCalculadora() {
		CalculadoraView view = (CalculadoraView) this.comboBox.getSelectedItem();
		this.calculadora = view.getCalculadora();
		this.imageView.updateImage(view.getNomeImagem());
		this.imageView.repaint();
		atualizaDensidade();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		atualizaCalculadora();
	}

	@Override
	public void insertUpdate(DocumentEvent event) {
		atualizaDensidade();
	}

	@Override
	public void removeUpdate(DocumentEvent event) {
		atualizaDensidade();
	}

	@Override
	public void changedUpdate(DocumentEvent event) {
		atualizaDensidade();
	}
}
