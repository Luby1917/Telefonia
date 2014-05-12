package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cliente.Cliente;

public class PanelClientes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 69433833837296703L;
	
	Cliente cliente;
	
	
	
	
		
	JLabel labelNombre;
	JLabel labelApellido;
	JLabel labelDNI;
	JLabel labelTelefono;
	JLabel labelDireccion;
	JLabel labelTarifa;
	
		
	JTextField textFieldNombre;
	JTextField textFieldApellido;
	JTextField textFieldDNI;
	JTextField textFieldTelefono;

	JPanel panelSuperior;
	JPanel panelCentral;
	JPanel panelInferior;
	
	public PanelClientes(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		panelSuperior = new JPanel();
		//panelSuperior.setBackground(Color.BLUE);
		
		panelInferior = new JPanel();
		//panelInferior.setBackground(Color.GRAY);
		
		panelSuperior.setLayout(new GridLayout(7, 2, 10, 10));
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setPreferredSize(new Dimension(80,20));
		labelApellido = new JLabel("Apellido");
		labelDNI = new JLabel("NIF");
		labelTelefono = new JLabel("Telefono");
		labelDireccion = new JLabel("Direccion");
		labelTarifa = new JLabel("Tarifa");
		
		textFieldNombre = new JTextField("Nombre");
		textFieldApellido = new JTextField("Apellido");
		textFieldDNI = new JTextField("NIF");
		textFieldTelefono = new JTextField("Telefono");
		
		panelSuperior.add(labelNombre);
		panelSuperior.add(textFieldNombre);
		panelSuperior.add(labelApellido);
		panelSuperior.add(textFieldApellido);
		panelSuperior.add(labelDNI);
		panelSuperior.add(textFieldDNI);
		panelSuperior.add(labelTelefono);
		panelSuperior.add(textFieldTelefono);
		panelSuperior.add(labelDireccion);
		panelSuperior.add(labelTarifa);
		
		add(panelSuperior, BorderLayout.NORTH);
		add(panelInferior, BorderLayout.SOUTH);
	}
	
	
	
	public void nuevoCliente(){
		setEditable(true);
		JButton botonGuardar = new JButton("GUARDAR");
		botonGuardar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//controlador.guardarDatos();
				
				System.out.println("GUARDAR CLIENTE");
			}
		});
		panelInferior.add(botonGuardar,BorderLayout.SOUTH);
	}
	
	public void modificarCliente(){
		setEditable(true);
		JButton botonModificar = new JButton("MODIFICAR");
		botonModificar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//controlador.guardarDatos();
				
				System.out.println("MODIFICAR CLIENTE");
			}
		});
		panelSuperior.add(botonModificar,BorderLayout.SOUTH);
		
	}
	
	public void mostrarCliente(){
		setEditable(false);
		
	}
	
	private void setEditable(boolean editable){
		textFieldNombre.setEditable(editable);
		textFieldApellido.setEditable(editable);
		textFieldDNI.setEditable(editable);
		textFieldTelefono.setEditable(editable);
	}

}
