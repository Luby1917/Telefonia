package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cliente.Direccion;
import facturas.Factura;
import fecha.Fecha;

public class PanelFactura extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7314633943459090764L;
	
	
	private JLabel labelId;
	private JLabel labelPeriodoFacturacion;
	private JLabel labelMinutosConsumidos;
	private JLabel labelImporte;
	
	private JLabel labelTarifa;
	private JLabel labelFechaEmision;
	
	private PanelTarifa panelTarifa;
	private PanelFecha panelFecha;
	
	private JTextField textId;
	private JTextField textPeriodoFacturacion;
	private JTextField textMinutosConsumidos;
	private JTextField textImporte;
	
	private JButton botonVerLlamadas; 
	
	private Vista miVista;
	
	public PanelFactura(Vista v){
		super();
		this.miVista = v;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		labelId = new JLabel("Codigo de factura");
		labelPeriodoFacturacion = new JLabel("Periodo de facturacion");
		labelMinutosConsumidos = new JLabel("Minutos Consumidos");
		labelImporte = new JLabel("Importe");
		labelTarifa = new JLabel("Tarifa");
		//labelTarifa.setHorizontalAlignment(SwingConstants.LEFT);
		//labelTarifa.setHorizontalTextPosition(SwingConstants.LEFT);
		labelFechaEmision = new JLabel("Fecha de emision");
		panelTarifa = new PanelTarifa();
		panelFecha = new PanelFecha();
		
		textId = new JTextField();
		textPeriodoFacturacion = new JTextField();
		textMinutosConsumidos = new JTextField();
		textImporte = new JTextField();
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new GridLayout(0,2));
		JPanel panelInferior = new JPanel();
		//panelInferior.setLayout(new GridLayout(0,2));
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.PAGE_AXIS));
		
		panelSuperior.add(labelId);
		panelSuperior.add(textId);
		panelSuperior.add(labelPeriodoFacturacion);
		panelSuperior.add(textPeriodoFacturacion);
		panelSuperior.add(labelMinutosConsumidos);
		panelSuperior.add(textMinutosConsumidos);
		panelSuperior.add(labelImporte);
		panelSuperior.add(textImporte);
		
		panelInferior.add(labelFechaEmision);
		panelInferior.add(panelFecha);
		panelInferior.add(labelTarifa);
		panelInferior.add(panelTarifa);
		
		botonVerLlamadas = new JButton("Ver llamadas");
		botonVerLlamadas.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//controlador.seleccionarPestaña(3);				
			}
		});
		panelInferior.add(botonVerLlamadas);
		
		add(panelSuperior);
		add(panelInferior);
		
		
	}
	
	

	public void mostrarFactura(Factura f){
		textId.setText(String.valueOf(f.getId()));
		textPeriodoFacturacion.setText(f.getPeriodoFacturacion().toString());
		textMinutosConsumidos.setText(String.valueOf(f.getSegundosConsumidos()));
		textImporte.setText(String.valueOf(f.getImporte()));
		
		panelTarifa.mostrarTarifa(f.getTarifaAplicada());
		panelFecha.mostrarFecha(f.getFecha());
		
		setEditable(false);
	}
	
	public void nuevaDireccion(){
		textId.setText("");
		textPeriodoFacturacion.setText("");
		textMinutosConsumidos.setText("");
		textImporte.setText("");
		setEditable(true);
	}
	
	private void setEditable(boolean editable){
		textId.setEditable(editable);
		textPeriodoFacturacion.setEditable(editable);
		textMinutosConsumidos.setEditable(editable);
		textImporte.setEditable(editable);
	}
	
	public void editarDireccion(){
		setEditable(true);
	}
	
	public int getId() {
		return Integer.parseInt(textId.getText());
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