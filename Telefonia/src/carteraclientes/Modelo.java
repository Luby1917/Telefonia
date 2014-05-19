package carteraclientes;

import java.io.Serializable;
import java.util.List;

import llamadas.Llamada;
import tarifas.Tarifa;
import cliente.Cliente;
import excepciones.ObjetoNoEncontrado;
import excepciones.ObjetoYaExistente;
import facturas.Factura;
import fecha.Periodo;
import gui.Vista;

public interface Modelo extends Serializable{
	public void setVista(Vista v);

	public boolean darDeAltaCliente(Cliente cliente) throws ObjetoYaExistente;

	public boolean borrarCliente(String NIF) throws ObjetoNoEncontrado;

	public boolean cambiarTarifaCliente(String NIF, Tarifa tarifa)
			throws ObjetoNoEncontrado;

	public Cliente recuperarDatosClienteNIF(String NIF)
			throws ObjetoNoEncontrado;

	public List<Cliente> recuperarListadoClientes();

	public void darAltaLlamada(String NIF, Llamada llamada)
			throws ObjetoNoEncontrado;

	public List<Llamada> listarLlamadasCliente(String NIF)
			throws ObjetoNoEncontrado;

	public void emitirFacturaCliente(String NIF) throws ObjetoNoEncontrado;

	public Factura recuperarDatosFactura(int id) throws ObjetoNoEncontrado;

	public List<Factura> recuperarListadoFacturasCliente(String NIF)
			throws ObjetoNoEncontrado;

	public List<Cliente> listarListadoClientesFecha(Periodo p);

	public List<Factura> listarListadoFacturasFecha(String NIF, Periodo p)
			throws ObjetoNoEncontrado;

	public List<Llamada> listarListadoLlamadasFecha(String NIF, Periodo p)
			throws ObjetoNoEncontrado;
	
	public String[] listarClientes();
	public String[] listarFacturas(String NIF);
	public String[] listarLlamadas(String NIF);
	public Cliente getCliente(String NIF);
	public Factura getFactura (int id);
	public Llamada getLlamada (String s);

}
