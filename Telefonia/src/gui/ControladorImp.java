package gui;

import java.util.ArrayList;
import java.util.List;

import llamadas.Llamada;
import carteraclientes.Modelo;
import cliente.Cliente;
import excepciones.ObjetoNoEncontrado;
import facturas.Factura;

public class ControladorImp implements Controlador {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7097292361946626127L;
	Vista miVista;
	Modelo miModelo;
	
	
	public String[] listarClientes(){
		List<Cliente> clientes = miModelo.recuperarListadoClientes();
		List<String> listaDNI = new ArrayList<String>();
		for(Cliente c : clientes){
			listaDNI.add(c.getNIF());
		}
		String[] a = listaDNI.toArray(new String[listaDNI.size()]);
		return a;
	
	}
	
	public String[] listarFacturas(String NIF){
		List<Factura> facturas = null;
		try {
			facturas = miModelo.recuperarListadoFacturasCliente(NIF);
			List<String> listaFacturas = new ArrayList<String>();
			for(Factura f : facturas){
				listaFacturas.add(f.getId()+"");//TODO cambiar la forma de listar las facturas
			}
			return (String[]) listaFacturas.toArray();
		} catch (ObjetoNoEncontrado e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String[] listarLlamadas(String NIF){
		List<Llamada> llamadas = null;
		try {
			llamadas = miModelo.listarLlamadasCliente(NIF);
			List<String> listaLlamadas = new ArrayList<String>();
			for(Llamada f : llamadas){
				listaLlamadas.add(f.getFecha().toString());
			}
			return (String[]) listaLlamadas.toArray();
		} catch (ObjetoNoEncontrado e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public void setVista(Vista v) {
		miVista = v;

	}

	@Override
	public void setModelo(Modelo m) {
		miModelo = m;

	}

}
