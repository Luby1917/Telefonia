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
import javax.swing.SwingConstants;

import cliente.Cliente;

public class PanelClientes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 69433833837296703L;
	
		
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDNI;
	private JLabel labelTelefono;
	private JLabel labelDireccion;
	private JLabel labelTarifa;
	
		
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldTelefono;

	private PanelTarifa panelTarifa;
	private PanelDireccion panelDireccion;
	
	
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	
	
	public PanelClientes(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.WHITE);
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.PAGE_AXIS));
		
		panelCentral = new JPanel();
		panelCentral.setBackground(Color.GRAY);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.DARK_GRAY);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.PAGE_AXIS));
		
		panelSuperior.setLayout(new GridLayout(4, 2, 10, 10));
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setPreferredSize(new Dimension(80,20));
		labelApellido = new JLabel("Apellido");
		labelDNI = new JLabel("NIF");
		labelTelefono = new JLabel("Telefono");
		labelDireccion = new JLabel("Direccion");
		labelDireccion.setHorizontalTextPosition(SwingConstants.LEFT);
		labelTarifa = new JLabel("Tarifa");
		labelTarifa.setHorizontalTextPosition(SwingConstants.LEFT);

		
		textFieldNombre = new JTextField("Nombre");
		textFieldApellido = new JTextField("Apellido");
		textFieldDNI = new JTextField("NIF");
		textFieldTelefono = new JTextField("Telefono");
		
		panelTarifa = new PanelTarifa();
		panelDireccion = new PanelDireccion();
		
		panelSuperior.add(labelNombre);
		panelSuperior.add(textFieldNombre);
		panelSuperior.add(labelApellido);
		panelSuperior.add(textFieldApellido);
		panelSuperior.add(labelDNI);
		panelSuperior.add(textFieldDNI);
		panelSuperior.add(labelTelefono);
		panelSuperior.add(textFieldTelefono);
		panelCentral.add(labelDireccion);
		panelCentral.add(panelDireccion);
		panelCentral.add(labelTarifa);
		panelCentral.add(panelTarifa);
		
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
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
	
	public void mostrarCliente(Cliente c){
		
		
		setEditable(false);
		
	}
	
	private void setEditable(boolean editable){
		textFieldNombre.setEditable(editable);
		textFieldApellido.setEditable(editable);
		textFieldDNI.setEditable(editable);
		textFieldTelefono.setEditable(editable);
	}

}
