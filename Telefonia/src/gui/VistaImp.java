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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import menu.Opciones;
import menu.OpcionesCliente;
import menu.OpcionesFactura;
import menu.OpcionesLlamada;
import carteraclientes.Modelo;


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
	EscuchadorRaton er;


	public VistaImp() {
		er = new EscuchadorRaton();
	}
	
	public void crear(){
		frm = new JFrame("VENTANA");
		lay = new BorderLayout();
		
		//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.addWindowListener(new EscuchadorVentana());
		panelPrincipal = frm.getContentPane();
		JTabbedPane panelDePestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.add(panelDePestanas);

		//CLIENTES
		JPanel pestanaClientes = new JPanel();
		pestanaClientes.setLayout(new BorderLayout());
		panelDePestanas.add("Clientes",  pestanaClientes);
		
		//TOP
		JPanel superiorClientes = new JPanel();
		superiorClientes.setLayout(new GridLayout(2,1));
		pestanaClientes.add(superiorClientes , BorderLayout.NORTH);
		
	
	
		//BOTONERA
		JPanel  botoneraClientes = new JPanel();
		botoneraClientes.setLayout(new FlowLayout());
		superiorClientes.add(botoneraClientes, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesCliente.class, botoneraClientes, "Clientes");
		
		//LISTA//TODO error en el scroll/lista
		String[] listadoDNI = miControlador.listarClientes();
		if (listadoDNI==null){
			System.out.println("NULL");
		}
		//Compruebo de que ningun elemento de listadoDNI sea null
		for(int i = 0; i <listadoDNI.length; i++) {
			if(listadoDNI[i]==null){
				System.out.println("NULL "+i);
			}else{
				System.out.println(listadoDNI[i]);
			}
		}
		
		JList<String> listaClientes = new JList<String>(listadoDNI);
		//listaClientes.setVisibleRowCount(10);
		
		
		JScrollPane scroll = new JScrollPane(listaClientes);
		pestanaClientes.add(scroll, BorderLayout.WEST);
		//pestanaClientes.add(listaClientes, BorderLayout.WEST);
		
		
		//ZONA CENTRAL
		JPanel centroClientes = new JPanel(new BorderLayout());
		pestanaClientes.add(centroClientes,BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorClientes = new JLabel("Ultima accion clientes");
		pestanaClientes.add(textoInferiorClientes,BorderLayout.SOUTH);
		
		
		
		
		
		
		
		/*
		//FACTURAS
		JPanel pestanaFacturas = new JPanel();
		panelDePestanas.addTab("Facturas", null, pestanaFacturas, null);
		pestanaFacturas.setLayout(new BorderLayout());
		
		//TOP
		
		JPanel superiorFacturas = new JPanel();
		superiorFacturas.setLayout(new GridLayout(2,1));
		pestanaFacturas.add(superiorFacturas , BorderLayout.NORTH);
	
		
		//BOTONERA
		JPanel  botoneraFacturas = new JPanel();
		botoneraFacturas.setLayout(new FlowLayout());
		superiorFacturas.add(botoneraFacturas, FlowLayout.LEFT);
		
		contruirBotonera(OpcionesFactura.class, botoneraFacturas);

		//LISTA	
		String[] listadoFacturas = miControlador.listarClientes();//TODO
		JList<String> listaFacturas = new JList<String>(listadoFacturas);
		pestanaFacturas.add(new JScrollPane(listaFacturas), BorderLayout.WEST);
		
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
		
			
		//BOTONERA
		JPanel  botoneraLlamadas = new JPanel();
		botoneraLlamadas.setLayout(new FlowLayout());
		contruirBotonera(OpcionesLlamada.class, botoneraLlamadas);
		superiorLlamadas.add(botoneraLlamadas, FlowLayout.LEFT);
		
		//LISTA
		String[] listadoLlamadas = miControlador.listarClientes();//TODO
		JList<String> listaLlamadas = new JList<String>(listadoLlamadas);
		pestanaLlamadas.add(new JScrollPane(listaLlamadas), BorderLayout.WEST);
		
		//ZONA CENTRAL
		JPanel centroLlamadas = new JPanel(new BorderLayout());
		pestanaLlamadas.add(centroLlamadas, BorderLayout.CENTER);
		//ZONA INFERIOR
		JLabel textoInferiorLlamadas = new JLabel("Ultima accion llamadas");
		pestanaLlamadas.add(textoInferiorLlamadas, BorderLayout.SOUTH);
		*/
	}
	
	private void contruirBotonera(Class opciones, JPanel botonera, String name){
		Object[] values = opciones.getEnumConstants();
	    for (Object value : values) {
			JButton b = new JButton(((Opciones)value).getDescripcion());
			b.setName(name);
			b.setActionCommand(((Opciones)value).getAction());
			b.addActionListener(er);
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
	private class EscuchadorRaton implements ActionListener, Serializable{

		private static final long serialVersionUID = 8381362575484575192L;
		
		
		

		@Override
		public void actionPerformed(ActionEvent event) {

			JButton b = (JButton) event.getSource();
			switch(b.getName()){
			case "Clientes":
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
				break;
			case "Facturas":
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
				break;
			case "Llamadas":
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
				break;
			}

			
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
