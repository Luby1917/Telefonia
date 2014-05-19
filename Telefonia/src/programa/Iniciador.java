package programa;

import java.util.Iterator;

import llamadas.Llamada;
import carteraclientes.CarteraClientes;
import cliente.Cliente;
import excepciones.ObjetoNoEncontrado;
import excepciones.ObjetoYaExistente;
import facturas.Factura;
import generador.Generador;

public class Iniciador {
	static CarteraClientes cc;
	public Iniciador(int n){
		cc = new CarteraClientes();
		
		Generador gn;
		String telefonoDestino;
		int loop = 0;
		// Genera Clientes
		Cliente c;
		gn = new Generador();
		while (loop < n) {
		
			c = gn.generaParticular();
			String NIF = c.getNIF();
			try {
				cc.darDeAltaCliente(c);
			} catch (ObjetoYaExistente e) {
				System.out.println(e.getMessage());
			}
			
			loop++;
			try {
				System.out.println(cc.recuperarDatosClienteNIF(NIF).toString());
			} catch (ObjetoNoEncontrado e) {
				System.out.println("Esto no deberia petar");
				e.printStackTrace();
			}

			for (int i = 0; i < n; i++) {// facturas
				for (int j = 0; j < n; j++) {// crea llamadas
					int duracion = 1+(int) (Math.random() * 9);
					telefonoDestino = gn.generaTelefono();
					Llamada l = new Llamada(c.getTelefono(),telefonoDestino, duracion, c.getTarifa());
					
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("Fallo inciaciador, generacion de llamadas");
					}
					
					c.anadirLlamada(l);
					
				}
				
				c.emitirFactura();
			}
						
		}
		gn = null;
		//new Menu(cc);
	} 
	
	public CarteraClientes get(){
		return cc; 
	}
}
