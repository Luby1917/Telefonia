package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import cliente.Cliente;
import cliente.Direccion;
import cliente.Particular;
import fecha.Fecha;

public class PanelClientes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 69433833837296703L;
	
		
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDNI;
	private JLabel labelTelefono;
	private JLabel labelCorreoE;
	private JLabel labelFecha;
	private JLabel labelDireccion;
	private JLabel labelTarifa;
	private JLabel labelTipoCliente;

		
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDNI;
	private JTextField textFieldTelefono;
	private JTextField textFieldCorreoE;
	
	
	private PanelTarifa panelTarifa;
	private PanelDireccion panelDireccion;
	private PanelFecha panelFecha;
	
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;
	
	private JRadioButton botonEmpresa, botonParticular;
	private JButton boton, botonVerFacturas, botonVerLlamadas;
	
	private Vista miVista;
	private Controlador miControlador;
	 
	public PanelClientes(Vista v){
		super();
		this.miVista = v;
		this.miControlador = v.getControlador();
		
		botonVerFacturas = new JButton("Ver Facturas");
		botonVerFacturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String NIF = miVista.getClienteSeleccionado();
				miVista.setListaFacturas(miControlador.listarFacturas(NIF));
				miVista.seleccionarPestana(1);
				miVista.actualizar();
			}
		});
		
		botonVerLlamadas = new JButton("Ver Llamadas");
		botonVerLlamadas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String NIF = miVista.getClienteSeleccionado();
				miVista.setListaLlamadas(miControlador.listarLlamadas(NIF));
				miVista.seleccionarPestana(3);
				miVista.actualizar();
			}
		});
		
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JPanel panelTipoCliente = new JPanel();
		botonEmpresa = new JRadioButton("Empresa");
		botonParticular = new JRadioButton("Particular");
		botonParticular.setSelected(true);		
		
		ButtonGroup grupoOpciones = new ButtonGroup();
		ActionListener listener;
		botonEmpresa.addActionListener(listener=new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton b = (JRadioButton) e.getSource();
				if(b.getText()=="Empresa"){
					textFieldApellido.setEnabled(false);
					labelApellido.setEnabled(false);
					textFieldApellido.setVisible(false);
					labelApellido.setVisible(false);
					panelSuperior.remove(labelApellido);
					panelSuperior.remove(textFieldApellido);
					updateUI();
				}else if(b.getText()=="Particular"){
					textFieldApellido.setEnabled(true);
					labelApellido.setEnabled(true);
					textFieldApellido.setVisible(true);
					labelApellido.setVisible(true);
					panelSuperior.add(labelApellido,4);
					panelSuperior.add(textFieldApellido,5);
					updateUI();
				}
		
			}
		});
		botonParticular.addActionListener(listener);
		grupoOpciones.add(botonEmpresa);
		grupoOpciones.add(botonParticular);
		
		panelTipoCliente.add(botonParticular);
		panelTipoCliente.add(botonEmpresa);
		
		panelSuperior = new JPanel();
				
		panelCentral = new JPanel();
		panelCentral.setBackground(Color.GRAY);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
		
		panelInferior = new JPanel();
		panelInferior.setBackground(Color.GRAY);
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.PAGE_AXIS));
		
		panelSuperior.setLayout(new GridLayout(0, 2, 10, 10));
		
		labelTipoCliente = new JLabel("Tipo cliente");
		
		labelNombre = new JLabel("Nombre");
		//labelNombre.setPreferredSize(new Dimension(80,20));
		labelApellido = new JLabel("Apellido");
		labelDNI = new JLabel("NIF");
		labelTelefono = new JLabel("Telefono");
		labelCorreoE = new JLabel("Correo Electronico");
		labelFecha = new JLabel("Fecha");
		labelDireccion = new JLabel("Direccion");
		//labelDireccion.setHorizontalTextPosition(SwingConstants.LEFT);
		labelTarifa = new JLabel("Tarifa");
		//labelTarifa.setHorizontalTextPosition(SwingConstants.LEFT);

		
		textFieldNombre = new JTextField("Nombre");
		textFieldApellido = new JTextField("Apellido");
		textFieldDNI = new JTextField("NIF");
		textFieldTelefono = new JTextField("Telefono");
		textFieldCorreoE = new JTextField("Correo Electronico");
		panelFecha = new PanelFecha();
		
		panelTarifa = new PanelTarifa();
		panelDireccion = new PanelDireccion();
		
		panelSuperior.add(labelTipoCliente);
		panelSuperior.add(panelTipoCliente);
		
		panelSuperior.add(labelNombre);
		panelSuperior.add(textFieldNombre);
		panelSuperior.add(labelApellido);
		panelSuperior.add(textFieldApellido);
		panelSuperior.add(labelDNI);
		panelSuperior.add(textFieldDNI);
		panelSuperior.add(labelTelefono);
		panelSuperior.add(textFieldTelefono);
		panelSuperior.add(labelCorreoE);
		panelSuperior.add(textFieldCorreoE);
		panelSuperior.add(labelFecha);
		panelSuperior.add(panelFecha);
		panelCentral.add(labelDireccion);
		panelCentral.add(panelDireccion);
		panelCentral.add(labelTarifa);
		panelCentral.add(panelTarifa);
		panelCentral.add(botonVerFacturas);
		panelCentral.add(botonVerLlamadas);
		
		boton = new JButton("GUARDAR");
		
		boton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.guardarDatos();
				JButton b = (JButton) e.getSource();
				switch(b.getActionCommand()){

				case "MODIFICAR":
					System.out.println("MODIFICAR CLIENTE");//TODO Controlador
					break;
				case "GUARDAR":
					System.out.println("GUARDAR CLIENTE");//TODO Controlador
					break;

				}
				
			}
		});
		panelInferior.add(boton,BorderLayout.SOUTH);
		
		
		add(panelSuperior, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelInferior, BorderLayout.SOUTH);
	}
	
	
	
	public void nuevoCliente(){
		setEditable(true);
		boton.setActionCommand("NUEVO");
	}
	
	public void modificarCliente(){
		setEditable(true);
		boton.setActionCommand("MODIFICAR");
	}
	
	public void mostrarCliente(Cliente c){
		
		if(c instanceof Particular){
			System.out.println("P");
			Particular p = (Particular) c;
			textFieldApellido.setText(p.getApellidos());
		}
		textFieldNombre.setText(c.getNombre());
		textFieldDNI.setText(c.getNIF());
		textFieldTelefono.setText(c.getTelefono());
		textFieldCorreoE.setText(c.getCorreoE());
		panelFecha.mostrarFecha(c.getFecha());
		panelTarifa.mostrarTarifa(c.getTarifa());
		panelDireccion.mostrarDireccion(c.getDireccion());
		setEditable(false);
		
		
	}
	
	private void setEditable(boolean editable){
		textFieldNombre.setEditable(editable);
		textFieldApellido.setEditable(editable);
		textFieldDNI.setEditable(editable);
		textFieldTelefono.setEditable(editable);
		textFieldCorreoE.setEditable(editable);
		boton.setEnabled(editable);
	}
	
	public boolean esParticular(){
		return botonParticular.isSelected();
	}
	
	public String getApellido(){
		return textFieldApellido.getText();
	}
	
	public String getNIF(){
		return textFieldDNI.getText();
	}
	
	public String getTelefono(){
		return textFieldTelefono.getText();
	}
	
	public String getCorreoE(){
		return textFieldCorreoE.getText();
	}
	
	public Fecha getFecha(){
		Fecha f= new Fecha();
		f.setFecha(panelFecha.getDia(), panelFecha.getMes(), panelFecha.getAnyo());
		return f;

	}
	
	public String getTarifaDiaGratis(){
		return panelTarifa.getDiaGratis();
	}
	
	public String getTarifaHorasRebajadas(){
		return panelTarifa.getHorasRebajadas();
	}
	
	public Direccion getDireccion(){
		return panelDireccion.guardarDireccion();
	}
	
	
	

	
}
