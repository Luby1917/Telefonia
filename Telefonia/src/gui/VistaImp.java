package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import menu.Opciones;
import menu.OpcionesCliente;
import menu.OpcionesFactura;
import menu.OpcionesLlamada;
import carteraclientes.Modelo;
import cliente.Cliente;
import facturas.Factura;


public class VistaImp implements Vista{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4124473914597220306L;
	Modelo miModelo;
	Controlador miControlador;
	
	JFrame frm;
	Container panelPrincipal;
	LayoutManager lay;
	
	JTabbedPane panelDePestanas;
	JPanel pestanaClientes, pestanaFacturas, pestanaLlamadas;
	JPanel  botoneraClientes, botoneraFacturas, botoneraLlamadas;
	JList<String> listaFacturas, listaClientes, listaLlamadas;
	int indiceClientes, indiceFacturas, indiceLlamadas;
	
	public VistaImp() {
	}
	
	public void crear(){
		frm = new JFrame("VENTANA");
		lay = new BorderLayout();
		
		//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addWindowListener(new EscuchadorVentana());
		panelPrincipal = frm.getContentPane();
		panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(panelDePestanas);

		
		
		//CLIENTES
		pestanaClientes = new JPanel();
		pestanaClientes.setLayout(new BorderLayout());
		panelDePestanas.add("Clientes",  pestanaClientes);
		
		//TOP
		JPanel superiorClientes = new JPanel();
		superiorClientes.setLayout(new GridLayout(2,1));
		pestanaClientes.add(superiorClientes , BorderLayout.NORTH);
		
	
	
		//BOTONERA
		botoneraClientes = new JPanel();
		botoneraClientes.setLayout(new FlowLayout());
		superiorClientes.add(botoneraClientes, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesCliente.class, botoneraClientes, "Clientes");
		
		//LISTA//TODO error en el scroll/lista
		String[] listadoDNI = miControlador.listarClientes();
			
		listaClientes = new JList<String>(listadoDNI);
		listaClientes.setFixedCellWidth(80);
		//listaClientes.setVisibleRowCount(10);
		listaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		
		JScrollPane scroll = new JScrollPane(listaClientes);
		pestanaClientes.add(scroll, BorderLayout.WEST);
		//pestanaClientes.add(listaClientes, BorderLayout.WEST);
		
		
		//ZONA CENTRAL
		final PanelClientes panelClientes = new PanelClientes(this);
		
		pestanaClientes.add(panelClientes,BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorClientes = new JLabel("Ultima accion clientes");
		pestanaClientes.add(textoInferiorClientes,BorderLayout.SOUTH);
				
		//FACTURAS
		pestanaFacturas = new JPanel();
		panelDePestanas.addTab("Facturas", null, pestanaFacturas, null);
		pestanaFacturas.setLayout(new BorderLayout());
		
		//TOP
		JPanel superiorFacturas = new JPanel();
		superiorFacturas.setLayout(new GridLayout(2,1));
		pestanaFacturas.add(superiorFacturas , BorderLayout.NORTH);
			
		//BOTONERA
		botoneraFacturas = new JPanel();
		botoneraFacturas.setLayout(new FlowLayout());
		superiorFacturas.add(botoneraFacturas, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesFactura.class, botoneraFacturas, "Facturas");

		//LISTA	
		listaFacturas = new JList<String>();
		listaFacturas.setFixedCellWidth(80);
		pestanaFacturas.add(new JScrollPane(listaFacturas), BorderLayout.WEST);
		
		//ZONA CENTRAL
		final PanelFactura panelFactura = new PanelFactura(this);
		pestanaFacturas.add(panelFactura, BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorFacturas = new JLabel("Ultima accion facturas");
		pestanaFacturas.add(textoInferiorFacturas, BorderLayout.SOUTH);
		
		//LLAMADAS
		pestanaLlamadas = new JPanel();
		panelDePestanas.addTab("Llamadas", null, pestanaLlamadas, null);
		pestanaLlamadas.setLayout(new BorderLayout());
		
		//TOP
		JPanel superiorLlamadas = new JPanel();
		superiorLlamadas.setLayout(new GridLayout(2,1));
		pestanaLlamadas.add(superiorLlamadas, BorderLayout.NORTH);
			
		//BOTONERA
		botoneraLlamadas = new JPanel();
		botoneraLlamadas.setLayout(new FlowLayout());
		contruirBotonera(OpcionesLlamada.class, botoneraLlamadas, "Llamadas");
		superiorLlamadas.add(botoneraLlamadas, FlowLayout.LEFT);
		
		//LISTA
		listaLlamadas = new JList<String>();
		listaLlamadas.setFixedCellWidth(120);
		pestanaLlamadas.add(new JScrollPane(listaLlamadas), BorderLayout.WEST);
		
		//ZONA CENTRAL
		PanelLlamada panelLlamada = new PanelLlamada(this);
		pestanaLlamadas.add(panelLlamada, BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorLlamadas = new JLabel("Ultima accion llamadas");
		pestanaLlamadas.add(textoInferiorLlamadas, BorderLayout.SOUTH);
			
		
		
		listaClientes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				//indiceClientes = event.getFirstIndex();
				Cliente c = miControlador.getCliente(listaClientes.getSelectedValue());
				panelClientes.mostrarCliente(c);
			}
		});
		
		listaFacturas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				//indiceFacturas = event.getFirstIndex();
				int id = Integer.parseInt(listaFacturas.getSelectedValue());
				System.out.println(id);
				Factura f = miControlador.getFactura(id);
				panelFactura.mostrarFactura(f);
			}
		});
		
		listaLlamadas.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				//indiceLlamadas = event.getFirstIndex();
			}
		});
		

		actualizar();
		
	}
	
	private void contruirBotonera(Class opciones, JPanel botonera, String name){
		Object[] values = opciones.getEnumConstants();
		ActionListener escuchador = null;
		switch(name){
		case "Clientes":
			escuchador = new EscuchadorBotonesCliente();
			break;
		case "Facturas":
			escuchador = new EscuchadorBotonesFactura();
			break;
		case "Llamadas":
			escuchador = new EscuchadorBotonesLlamada();
			break;
		}
		for (Object value : values) {
			JButton b = new JButton(((Opciones)value).getDescripcion());
			b.setName(name);
			b.setActionCommand(((Opciones)value).getAction());
			b.addActionListener(escuchador);
			botonera.add(b);
		}
	}
	
	public void actualizar(){
		pestanaLlamadas.updateUI();
		pestanaClientes.updateUI();
		pestanaFacturas.updateUI();
	}
	
	
	public void mostrar (){
		actualizar();
		frm.pack();
		frm.setVisible(true);
	}

	
	private class EscuchadorVentana extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("ADIOS");
			System.exit(0);
		}
		
	}
	
	public void seleccionarPestana(int i){
		switch(i){
		case 0:
			panelDePestanas.setSelectedComponent(pestanaClientes);
			break;
		case 1:
			panelDePestanas.setSelectedComponent(pestanaFacturas);
			break;
		case 2:
			panelDePestanas.setSelectedComponent(pestanaLlamadas);
			break;
		}
	}

	@Override
	public void setModelo(Modelo m) {
		miModelo = m;		
	}

	@Override
	public void setControlador(Controlador c) {
		miControlador = c;
	}
	
	private class EscuchadorBotonesCliente implements ActionListener, Serializable{

		private static final long serialVersionUID = 8381362575484575192L;
		
		@Override
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			switch(b.getActionCommand()){
			case "ATRAS":
				System.out.println(b.getActionCommand());
				break;
			case "NUEVO":
				System.out.println(b.getActionCommand());
				break;
			case "BORRAR":
				System.out.println(b.getActionCommand());
				break;
			case "CAMBIAR":
				System.out.println(b.getActionCommand());
				break;
			case "BUSCAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR_FECHA":
				System.out.println(b.getActionCommand());
				break;
			}
		}
	}

	private class EscuchadorBotonesFactura implements ActionListener, Serializable{

		private static final long serialVersionUID = -5837266124361773762L;

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			switch(b.getActionCommand()){
			case "EMITIR":
				System.out.println(b.getActionCommand());
				break;
			case "BUSCAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR_FECHA":
				System.out.println(b.getActionCommand());
				break;
			}
		}
	}

	private class EscuchadorBotonesLlamada implements ActionListener, Serializable{

		private static final long serialVersionUID = 7675735510653870155L;

		@Override
		public void actionPerformed(ActionEvent event) {
			JButton b = (JButton) event.getSource();
			switch(b.getActionCommand()){
			case "NUEVA":
				System.out.println(b.getActionCommand());
				break;
			case "BUSCAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR":
				System.out.println(b.getActionCommand());
				break;
			case "LISTAR_FECHA":
				System.out.println(b.getActionCommand());
				break;
			}
		}
	}

	@Override
	public Modelo getModelo() {
		return miModelo;
	}

	@Override
	public Controlador getControlador() {
		return miControlador;
	}

	@Override
	public String getClienteSeleccionado() {
		return listaClientes.getSelectedValue();
	}

	@Override
	public void setListaFacturas(String[] facturas) {
		listaFacturas.setListData(facturas);
		
	}

	@Override
	public void setListaLlamadas(String[] llamadas) {
		listaLlamadas.setListData(llamadas);
		
	}

}
