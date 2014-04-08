package carteraclientes;


import menu.LectorDatos;
import cliente.Cliente;

public class FactoriaClientes {
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
//irene!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!:o!!!!!!!!!!^.^€$€$€$$€€€€€€€/
}
