package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import menu.Opciones;
import menu.OpcionesCliente;
import menu.OpcionesFactura;
import menu.OpcionesLlamada;
import carteraclientes.Modelo;


public class VistaImp implements Vista{
	Modelo miModelo;
	Controlador miControlador;
	
	JFrame frm;
	Container panelPrincipal;
	LayoutManager lay;
	
	GridBagConstraints c;

	public VistaImp() {
	}
	
	public void crear(){
		frm = new JFrame("VENTANA");
		lay = new BorderLayout();
		c = new GridBagConstraints();
		//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addWindowListener(new EscuchadorVentana());
		panelPrincipal = frm.getContentPane();
		JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(panelDePestanas);

		//CLIENTES
		JPanel pestanaClientes = new JPanel();
		pestanaClientes.setLayout(new BorderLayout());
		panelDePestanas.addTab("Clientes", null, pestanaClientes, null);
		
		//TOP
		JPanel superiorClientes = new JPanel();
		superiorClientes.setLayout(new GridLayout(2,1));
		pestanaClientes.add(superiorClientes , BorderLayout.NORTH);
		
		//TITULO
		/*
		JLabel tituloClientes = new JLabel("Clientes");
		tituloClientes.setHorizontalAlignment(JLabel.CENTER);
		superiorClientes.add(tituloClientes);
		*/
	
		//BOTONERA
		JPanel  botoneraClientes = new JPanel();
		botoneraClientes.setLayout(new FlowLayout());
		superiorClientes.add(botoneraClientes, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesCliente.class, botoneraClientes);
		
		//LISTA//TODO error en el scrol
		String[] listadoDNI = miControlador.listarClientes();
		JList<String> listaClientes = new JList<String>(listadoDNI);
		listaClientes.setVisibleRowCount(10);
		JScrollPane scroll = new JScrollPane(listaClientes);
		pestanaClientes.add(scroll, BorderLayout.WEST);
		//pestanaClientes.add(listaClientes, BorderLayout.WEST);

		
		//ZONA CENTRAL
		JPanel centroClientes = new JPanel(new BorderLayout());
		pestanaClientes.add(centroClientes,BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorClientes = new JLabel("Ultima accion clientes");
		pestanaClientes.add(textoInferiorClientes,BorderLayout.SOUTH);
		
		//FACTURAS
		JPanel pestanaFacturas = new JPanel();
		panelDePestanas.addTab("Facturas", null, pestanaFacturas, null);
		pestanaFacturas.setLayout(new BorderLayout());
		
		//TOP
		
		JPanel superiorFacturas = new JPanel();
		superiorFacturas.setLayout(new GridLayout(2,1));
		pestanaFacturas.add(superiorFacturas , BorderLayout.NORTH);
		
		//TITULO
		/*
		JLabel tituloFacturas = new JLabel("Facturas");
		tituloFacturas.setHorizontalAlignment(JLabel.CENTER);
		superiorFacturas.add(tituloFacturas);
		*/
		
		//BOTONERA
		JPanel  botoneraFacturas = new JPanel();
		botoneraFacturas.setLayout(new FlowLayout());
		superiorFacturas.add(botoneraFacturas, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesFactura.class, botoneraFacturas);
		/*
		//LISTA	
		String[] listadoFacturas = miControlador.listarClientes();//TODO
		JList<String> listaFacturas = new JList<String>(listadoFacturas);
		pestanaFacturas.add(new JScrollPane(listaFacturas), BorderLayout.WEST);
		*/
		//ZONA CENTRAL
		JPanel centroFacturas = new JPanel(new BorderLayout());
		pestanaFacturas.add(centroFacturas, BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorFacturas = new JLabel("Ultima accion facturas");
		pestanaFacturas.add(textoInferiorFacturas, BorderLayout.SOUTH);
		
		//LLAMADAS
		JPanel pestanaLlamadas = new JPanel();
		panelDePestanas.addTab("Llamadas", null, pestanaLlamadas, null);
		pestanaLlamadas.setLayout(new BorderLayout());
		
		//TOP
		
		JPanel superiorLlamadas = new JPanel();
		superiorLlamadas.setLayout(new GridLayout(2,1));
		pestanaLlamadas.add(superiorLlamadas, BorderLayout.NORTH);
		
		//TITULO
		/*
		JLabel tituloLlamadas = new JLabel("Llamadas");
		tituloLlamadas.setHorizontalAlignment(JLabel.CENTER);
		superiorLlamadas.add(tituloLlamadas);
		*/
		
		//BOTONERA
		JPanel  botoneraLlamadas = new JPanel();
		botoneraLlamadas.setLayout(new FlowLayout());
		contruirBotonera(OpcionesLlamada.class, botoneraLlamadas);
		superiorLlamadas.add(botoneraLlamadas, FlowLayout.LEFT);
		/*
		//LISTA
		String[] listadoLlamadas = miControlador.listarClientes();//TODO
		JList<String> listaLlamadas = new JList<String>(listadoLlamadas);
		pestanaLlamadas.add(new JScrollPane(listaLlamadas), BorderLayout.WEST);
		*/
		//ZONA CENTRAL
		JPanel centroLlamadas = new JPanel(new BorderLayout());
		pestanaLlamadas.add(centroLlamadas, BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorLlamadas = new JLabel("Ultima accion llamadas");
		pestanaLlamadas.add(textoInferiorLlamadas, BorderLayout.SOUTH);
		
	}
	
	private void contruirBotonera(Class opciones, JPanel botonera){
		Object[] values = opciones.getEnumConstants();
	    for (Object value : values) {
			JButton b = new JButton(((Opciones)value).getDescripcion());
			botonera.add(b);
		}
	}

	
	public void mostrar (){
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


	@Override
	public void setModelo(Modelo m) {
		miModelo = m;		
	}

	@Override
	public void setControlador(Controlador c) {
		miControlador = c;
	}

}
