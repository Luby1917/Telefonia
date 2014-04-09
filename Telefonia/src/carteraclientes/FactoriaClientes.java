package carteraclientes;


import java.io.Serializable;

import menu.LectorDatos;
import cliente.Cliente;

public class FactoriaClientes   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5579902410123026476L;
	Cliente cliente;
	LectorDatos ld;
	public FactoriaClientes(LectorDatos ld) {
		this.ld = ld;

	}
	public Cliente getCliente(TipoCliente tipoCliente){
		boolean particular = true;
		switch(tipoCliente){
		case PARTICULAR:
			 particular = true;			
			break;
		case EMPRESA:
			 particular = false;
			break;
		}	
		cliente = ld.pedirDatosCliente(particular);
		
		return cliente;
	}

}
