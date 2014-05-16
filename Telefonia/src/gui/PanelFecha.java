package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fecha.Fecha;

public class PanelFecha extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2271737946818397957L;

	JLabel labelDia;
	JLabel labelMes;
	JLabel labelAnyo;
	
	JTextField textFieldDia;
	JTextField textFieldMes;
	JTextField textFieldAnyo;
	
	public PanelFecha(){
		super();
		setLayout(new FlowLayout());
		
		labelDia = new JLabel("Dia");
		labelMes = new JLabel("Mes");
		labelAnyo = new JLabel("Año");
		
		textFieldDia= new JTextField(2);
		textFieldMes= new JTextField(2);
		textFieldAnyo= new JTextField(4);
		
		add(labelDia);
		add(textFieldDia);
		add(labelMes);
		add(textFieldMes);
		add(labelAnyo);
		add(textFieldAnyo);
	}
	
	public void nuevaFecha(){
		textFieldDia.setText("");
		textFieldMes.setText("");
		textFieldAnyo.setText("");
		setEditable(true);
	}
	
	public void mostrarFecha(Fecha f){
		textFieldDia.setText(String.valueOf(f.getDay()));
		textFieldMes.setText(String.valueOf(f.getMonth()));
		textFieldAnyo.setText(String.valueOf(f.getYear()));
		setEditable(false);
	}
	
	public int getDia(){
		return Integer.parseInt(textFieldDia.getText());
	}
	
	public int getMes(){
		return Integer.parseInt(textFieldMes.getText());
	}
	
	public int getAnyo(){
		return 	Integer.parseInt(textFieldAnyo.getText());
	}
	
	
	private void setEditable(boolean editable){
		textFieldDia.setEditable(editable);
		textFieldMes.setEditable(editable);
		textFieldAnyo.setEditable(editable);
	}

}
