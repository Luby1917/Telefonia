package  cliente;

import tarifas.Tarifa;

public class Empresa extends Cliente {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();

	}

	public Empresa(String nombre, String telefono, String NIF, Direccion direccion, Tarifa tarifa, String correoE) {
		super(nombre, telefono, NIF, direccion, tarifa, correoE);
	}

}