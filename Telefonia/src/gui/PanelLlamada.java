package gui;

import facturas.Factura;
import fecha.Fecha;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import llamadas.Llamada;

public class PanelLlamada extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7314633943459090764L;
	
	private JLabel labelTelefonoCliente;
	private JLabel labelTelefonoDestino;
	private JLabel labelDuracion;
	private JLabel labelCoste;
	
	private JLabel labelTarifa;
	private JLabel labelFecha;
	
	private PanelTarifa panelTarifa;
	private PanelFecha panelFecha;
	
	private JTextField textTelefonoCliente;
	private JTextField textTelefonoDestino;
	private JTextField textDuracion;
	private JTextField textCoste;
	
	private Vista miVista;

	public PanelLlamada(Vista v){
		super();
		this.miVista = v;
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		labelTelefonoCliente = new JLabel("Telefono cliente");
		labelTelefonoDestino = new JLabel("Telefono destino");
		labelDuracion = new JLabel("Duracion");
		labelCoste = new JLabel("Coste");
		labelTarifa = new JLabel("Tarifa");
		labelFecha = new JLabel("Fecha de la llamada");
	
		panelTarifa = new PanelTarifa();
		panelFecha = new PanelFecha();
		
		textTelefonoCliente = new JTextField();
		textTelefonoDestino = new JTextField();
		textDuracion = new JTextField();
		textCoste = new JTextField();
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(0,2));
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.PAGE_AXIS));
		
		panelSuperior.add(labelTelefonoCliente);
		panelSuperior.add(textTelefonoCliente);
		panelSuperior.add(labelTelefonoDestino);
		panelSuperior.add(textTelefonoDestino);
		panelSuperior.add(labelDuracion);
		panelSuperior.add(textDuracion);
		panelSuperior.add(labelCoste);
		panelSuperior.add(textCoste);
		
		panelInferior.add(labelFecha);
		panelInferior.add(panelFecha);
		panelInferior.add(labelTarifa);
		panelInferior.add(panelTarifa);
						
		add(panelSuperior);
		add(panelInferior);
		
		
	}
	
	

	public void mostrarLlamada(Llamada ll){
		textTelefonoCliente.setText(String.valueOf(ll.getTelefonoCliente()));
		textTelefonoDestino.setText(ll.getTelefonoDestino());
		textDuracion.setText(String.valueOf(ll.getDuracion()));
		textCoste.setText(String.valueOf(ll.getCoste()));
		
		panelTarifa.mostrarTarifa(ll.getTarifa());
		panelFecha.mostrarFecha(ll.getFecha());
		
		setEditable(false);
	}
	
	public void nuevaDireccion(){
		textTelefonoCliente.setText("");
		textTelefonoDestino.setText("");
		textCoste.setText("");
		textDuracion.setText("");
		setEditable(true);
	}
	
	private void setEditable(boolean editable){
		textTelefonoCliente.setEditable(editable);
		textTelefonoDestino.setEditable(editable);
		textDuracion.setEditable(editable);
		textCoste.setEditable(editable);
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
	
	
}