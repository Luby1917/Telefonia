package facturas;

import fecha.Fecha;
import fecha.Periodo;
import interfaces.InterfazFecha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tarifas.TarifaBasica;
import llamadas.Llamada;

public class Factura implements InterfazFecha, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int codBase = 0;
	private int id;
	private int minutosConsumidos;
	private TarifaBasica tarifaAplicada;
	private Fecha fechaEmision;
	private List<Llamada> llamadas;
	private String textoLlamadas;
	private double importe;
	private Periodo periodoFacturacion;

	public Factura() {

	}

	public Factura(TarifaBasica tarifaAplicada) {
		this.periodoFacturacion = new Periodo();
		this.minutosConsumidos = 0;
		this.tarifaAplicada = tarifaAplicada;
		this.llamadas = new ArrayList<Llamada>();
		this.textoLlamadas = "";
		this.id = codBase++;
	}

	private double calcularImporte(int minutos, TarifaBasica tarifa) {//TODO cambiar la forma de calcular el importe
		return  ((double) minutos * tarifa.getCoste() / 100);
	}

	public double getImporte() {
		return this.importe;
	}

	public void anadirLlamada(Llamada llamada) {
		this.minutosConsumidos += llamada.getDuracion();
		this.importe = calcularImporte(llamada.getDuracion(), llamada.getTarifa());
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

	public TarifaBasica getTarifaAplicada() {
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