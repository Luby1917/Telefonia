package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.Direccion;

public class PanelDireccion extends JPanel {
	private static final long serialVersionUID = -3823290491698784752L;
	
	private JLabel labelCodPostal;
	private JLabel labelProvincia;
	private JLabel labelPoblacion;
	private JTextField textCodPostal;
	private JTextField textProvincia;
	private JTextField textPoblacion;
	
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
	
	public void mostrarDireccion(Direccion d){
		textCodPostal.setText(String.valueOf(d.getCodPostal()));
		textProvincia.setText(d.getProvincia());
		textPoblacion.setText(d.getPoblacion());
		setEditable(false);
	}
	
	public void nuevaDireccion(){
		textCodPostal.setText("");
		textProvincia.setText("");
		textPoblacion.setText("");
		setEditable(true);
	}
	
	private void setEditable(boolean editable){
		textCodPostal.setEditable(editable);
		textProvincia.setEditable(editable);
		textPoblacion.setEditable(editable);
	}
	
	public void editarDireccion(){
		setEditable(true);
	}
	
	public Direccion guardarDireccion(){
		return new Direccion(getCodPostal(), getProvincia(), getPoblacion());
	}
}
