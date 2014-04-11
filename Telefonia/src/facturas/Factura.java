package facturas;

import fecha.Fecha;
import fecha.Periodo;
import interfaces.InterfazFecha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tarifas.Tarifa;
import llamadas.Llamada;

public class Factura implements InterfazFecha, Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2676748147264302430L;
	private static int codBase = 0;
	private int id;
	private int minutosConsumidos;
	private Tarifa tarifaAplicada;
	private Fecha fechaEmision;
	private List<Llamada> llamadas;
	private String textoLlamadas;
	private double importe;
	private Periodo periodoFacturacion;

	public Factura() {

	}

	public Factura(Tarifa tarifa) {
		this.periodoFacturacion = new Periodo();
		this.minutosConsumidos = 0;
		this.tarifaAplicada = tarifa;
		this.llamadas = new ArrayList<Llamada>();
		this.textoLlamadas = "";
		this.id = codBase++;
	}

	private double calcularImporte(Llamada llamada) {//TODO cambiar la forma de calcular el importe
		double coste =  getTarifaAplicada().calcularCoste(llamada);
		return  ((double)( llamada.getDuracion() * coste)) / 100;
	}

	public double getImporte() {
		return this.importe;
	}

	public void anadirLlamada(Llamada llamada) {
		this.minutosConsumidos += llamada.getDuracion();
		this.importe += calcularImporte(llamada);
		llamadas.add(llamada);
		textoLlamadas += ("\t" + llamada.toString());

	}

	public String toString() {
		return "Codigo de factura: " + id + "\nFecha :"
				+ fechaEmision.toString() + "\nPeriodo facturacion: "
				+ periodoFacturacion + "\nMinutos consumidos: "
				+ minutosConsumidos + "\nTarifa: " + tarifaAplicada
				+ "\nConsumo: " + String.format("%.02f", importe) + " €"
				+ "\nLlamadas: " + "\n" + textoLlamadas + "\n";
	}

	public Factura emitirFactura() {
		this.fechaEmision = new Fecha();
		this.periodoFacturacion.setFechaFin(fechaEmision);
		
		return this;
	}

	public int getSegundosConsumidos() {
		return minutosConsumidos;
	}

	public Tarifa getTarifaAplicada() {
		return tarifaAplicada;
	}

	

	public Fecha getFecha() {
		return fechaEmision;
	}

	public List<Llamada> getLlamadas() {
		return llamadas;
	}

	public int getId() {
		return id;
	}

	public Periodo getPeriodoFacturacion() {
		return periodoFacturacion;
	}
	
}