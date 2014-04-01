package  cliente;

import tarifas.TarifaBasica;

public class Empresa extends Cliente {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();

	}

	public Empresa(String nombre, String telefono, String NIF, Direccion direccion, TarifaBasica tarifa, String correoE) {
		super(nombre, telefono, NIF, direccion, tarifa, correoE);
	}

}