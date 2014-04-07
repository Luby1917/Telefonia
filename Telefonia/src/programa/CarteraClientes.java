package programa;

import interfaces.InterfazFecha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import llamadas.Llamada;
import tarifas.Tarifa;
import cliente.Cliente;
import excepciones.ListaVaciaException;
import excepciones.ObjetoNoEncontrado;
import excepciones.ObjetoYaExistente;
import facturas.Factura;
import fecha.Periodo;

public class CarteraClientes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Cliente> clientes;

	public CarteraClientes() {
		clientes = new TreeMap<String, Cliente>();

	}

	public boolean darDeAltaCliente(Cliente cliente) throws ObjetoYaExistente{

		if (!clientes.containsKey(cliente.getNIF()))
			clientes.put(cliente.getNIF(), cliente);
		else
			throw new ObjetoYaExistente("El cliente con el NIF "+ cliente.getNIF()+" ya existe");
		return true;

	}

	public boolean borrarCliente(String NIF) throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			clientes.remove(NIF);
		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");
		return true;
	}

	public boolean cambiarTarifaCliente(String NIF, Tarifa tarifa)
			throws ObjetoNoEncontrado {

		if (clientes.containsKey(NIF)) {
			clientes.get(NIF).setTarifa(tarifa);
		} else
			throw new ObjetoNoEncontrado();
		return true;
	}

	public Cliente recuperarDatosClienteNIF(String NIF)
			throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			return clientes.get(NIF);
		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");

	}

	public List<Cliente> recuperarListadoClientes() {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Iterator<Entry<String, Cliente>> it = clientes.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Cliente> c = (Entry<String, Cliente>) it.next();

			listaClientes.add(c.getValue());
		}
		return listaClientes;

	}

	public void darAltaLlamada(String NIF, Llamada llamada)
			throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			clientes.get(NIF).anadirLlamada(llamada);
		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");

	}

	public List<Llamada> listarLlamadasCliente(String NIF)
			throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			return clientes.get(NIF).getLlamadas();
		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");

	}

	public void emitirFacturaCliente(String NIF) throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			clientes.get(NIF).emitirFactura();
		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");

	}

	public Factura recuperarDatosFactura(int id) throws ObjetoNoEncontrado {
		Iterator<Entry<String, Cliente>> it = clientes.entrySet().iterator();
		while (it.hasNext()) {

			Entry<String, Cliente> c = (Entry<String, Cliente>) it.next();
			try {
				Factura fac = c.getValue().getFactura(id);
				return fac;// si no lanza una excepcion es que ha encontrado la
							// factura
			} catch (ObjetoNoEncontrado e) {
				// factura no encontrada en el cliente actual
			}
		}
		throw new ObjetoNoEncontrado("Factura no encontrada");

	}

	public List<Factura> recuperarListadoFacturasCliente(String NIF)
			throws ObjetoNoEncontrado {
		if (clientes.containsKey(NIF))
			return clientes.get(NIF).getFacturas();

		else
			throw new ObjetoNoEncontrado("Cliente no encontrado");

	}

	public List<Cliente> mostrarListadoClientesFecha(Periodo p) {

		try {
			return (List<Cliente>) listarPorFecha(clientes.values(), p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ArrayList<Cliente>();
	}

	public List<Factura> mostrarListadoFacturasFecha(String NIF, Periodo p)	throws ObjetoNoEncontrado {
		Cliente c;
		if (clientes.containsKey(NIF)) {
			c = clientes.get(NIF);
			try {
				return (List<Factura>) listarPorFecha(c.getFacturas(), p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return new ArrayList<Factura>();
	}
	
	public List<Llamada> mostrarListadoLlamadasFecha(String NIF, Periodo p)	throws ObjetoNoEncontrado {
		Cliente c;
		if (clientes.containsKey(NIF)) {
			c = clientes.get(NIF);
			try {
				return (List<Llamada>) listarPorFecha(c.getLlamadas(), p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return new ArrayList<Llamada>();
	}

	private <T extends InterfazFecha> Collection<T> listarPorFecha(
			Collection<T> c, Periodo p) throws ListaVaciaException,
			NullPointerException {

		if (c == null)
			throw new NullPointerException("La lista es null");

		if (c.isEmpty())
			throw new ListaVaciaException("La lista de "
					+ c.iterator().getClass().getName() + " esta vacia");

		List<T> l = new ArrayList<T>();
		Iterator<T> i = c.iterator();
		while (i.hasNext()) {
			T obj = i.next();
			if (p.estaDentro(obj.getFecha())) {
				l.add(obj);
			}
		}
		return l;
	}

}
