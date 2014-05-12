package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDireccion extends JPanel {
	
	
	private static final long serialVersionUID = -3823290491698784752L;
	
	JLabel labelCodPostal;
	JLabel labelProvincia;
	JLabel labelPoblacion;
	JTextField textCodPostal;
	JTextField textProvincia;
	JTextField textPoblacion;
	
	public PanelDireccion(){
		super();
		setLayout(new GridLayout(3,2));
		
		labelCodPostal = new JLabel("Codigo Postal");
		labelProvincia = new JLabel("Provincia");
		labelPoblacion = new JLabel("Poblacion");
		
		textCodPostal = new JTextField();
		textProvincia = new JTextField();
		textPoblacion = new JTextField();
		
		add(labelCodPostal);
		add(textCodPostal);
		add(labelProvincia);
		add(textProvincia);
		add(labelPoblacion);
		add(textPoblacion);
		
	}
	
	public int getCodPostal() {
		return Integer.parseInt(textCodPostal.getText());
	}
	public String getProvincia() {
		return textProvincia.getText();
	}
	public String getPoblacion() {
		return textPoblacion.getText();
	}


}
