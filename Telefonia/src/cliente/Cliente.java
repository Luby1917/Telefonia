package cliente;

import excepciones.ObjetoNoEncontrado;
import facturas.Factura;
import fecha.Fecha;
import interfaces.InterfazFecha;
import interfaces.InterfazObjeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import llamadas.Llamada;
import tarifas.Tarifa;
import tarifas.TarifaBasica;

public abstract class Cliente implements InterfazFecha, InterfazObjeto, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String telefono;
	private String NIF;
	private Direccion direccion;
	private String correoE;
	private Tarifa tarifa;
	private Fecha fechaAlta;
	private Factura facturaActual;
	private Map<Integer, Factura> facturas;

	public Cliente() {
		this.facturas = new HashMap<Integer, Factura>();

	}

	public Cliente(String nombre, String telefono, String NIF, Direccion direccion, Tarifa tarifa,
			String correoE) {
		this.telefono = telefono;
		this.tarifa = tarifa;
		this.nombre = nombre;
		this.NIF = NIF;
		this.direccion = direccion;
		this.correoE = correoE;
		this.fechaAlta = new Fecha();
		this.facturaActual = new Factura(tarifa);
		this.facturas = new HashMap<Integer, Factura>();

	}

	@Override
	public Fecha getFecha() {
		return fechaAlta;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

	public void anadirLlamada(Llamada llamada) {
		facturaActual.anadirLlamada(llamada);

	}

	public Factura getFactura(int id) throws ObjetoNoEncontrado {
		if (facturas.containsKey(id))
			return facturas.get(id);
		throw new ObjetoNoEncontrado("Factura no encontrada");
	}

	public List<Llamada> getLlamadas() {
		List<Llamada> llamadas = new ArrayList<Llamada>();
		llamadas.addAll(facturaActual.getLlamadas());
		Iterator<Entry<Integer, Factura>> it = facturas.entrySet().iterator();
		while (it.hasNext()) {

			Entry<Integer,Factura> e=(Entry<Integer,Factura>)it.next();
			llamadas.addAll(e.getValue().getLlamadas());
		}
		
		return llamadas;

	}

	public Factura emitirFactura() {
		facturaActual=facturaActual.emitirFactura();
		Factura fac =facturaActual;
		facturas.put(facturaActual.getId(), facturaActual);
		facturaActual = new Factura(getTarifa());
		return fac;

	}

	public List<Factura> getFacturas() {
		List<Factura> f = new ArrayList<Factura>();
		Iterator<Entry<Integer, Factura>> it = facturas.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Factura> e = it.next();
			f.add((Factura) e.getValue());
		}
		return f;

	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {

		return "Nombre: " + nombre + "\nNIF: " + NIF + "\nDireccion: "
				+ direccion + "\nCorreo-e: " + correoE + "\nTarifa: "
				+ tarifa.toString() + "\nFecha de alta: " + fechaAlta + "\n";

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente cl = (Cliente) obj;

		if ( getNIF().equals(cl.getNIF())&& getCorreoE().equals(cl.getCorreoE()))
			return true;
		return false;

	}

}