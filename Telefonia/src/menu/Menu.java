package menu;

import java.util.Iterator;
import java.util.List;

import llamadas.Llamada;
import tarifas.FactoriaTarifas;
import carteraclientes.CarteraClientes;
import carteraclientes.FactoriaClientes;
import cliente.Cliente;
import excepciones.ObjetoNoEncontrado;
import excepciones.ObjetoYaExistente;
import facturas.Factura;
import fecha.Periodo;

public class Menu {

	
	CarteraClientes cc;
	FactoriaClientes fc;
	FactoriaTarifas ft;
	LectorDatos ld;

	public Menu(CarteraClientes cc) {
		this.cc = cc;
		ld = new LectorDatos();
		fc = new FactoriaClientes(ld);
		ft = new FactoriaTarifas();
		escogerOpcion();
	}

	public void mostrarOpciones() {
		System.out.println("Escoge una opcion");
		System.out.println("1. Cliente");
		System.out.println("2. Factura");
		System.out.println("3. Llamada");
		System.out.println("0. Salir");
	}

	public void escogerOpcion() {
		mostrarOpciones();
		int opcion = ld.pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {
			case 1:// Cliente
				mostrarOpcionesCliente();
				escogerOpcionesCliente();

				break;
			case 2:// Factura
				mostrarOpcionesFactura();
				escogerOpcionesFactura();

				break;
			case 3:// Llamada
				mostrarOpcionesLlamada();
				escogerOpcionesLlamada();
				break;

			default:
				System.out.println("Opcion no valida");
				break;

			}
			opcion = ld.pedirNumeroEntero("");
		}
		// adios
	}

	public void mostrarOpcionesCliente() {
		System.out.println("Escoge una opcion");
		System.out.println("1. Dar de alta a un nuevo cliente");
		System.out.println("2. Borrar un cliente");
		System.out.println("3. Cambiar la tarifa de un cliente");
		System.out.println("4. Recuperar los datos de un cliente");
		System.out.println("5. Recuperar el listado de todos los clientes");
		System.out
				.println("6. Recuperar el listado de clientes que fueron dados de alta entre dos fechas");
		System.out.println("0. Atras");
	}

	public void escogerOpcionesCliente() {
		List<Cliente> clientes;
		Iterator<Cliente> it;
		int opcion = ld.pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {

			case 1:// a�adir cliente//TODO FACTORIA
				Cliente c = fc.getCliente(ld.pedirTipoCliente());
				try {
					cc.darDeAltaCliente(c);
					System.out.println("Nuevo cliente a�adido");
				} catch (ObjetoYaExistente e) {
					System.out.println("ERROR");
					System.out.println(e.getMessage());

				}
				break;

			case 2:// borrar cliente (NIF)
				try {
					cc.borrarCliente(ld.pedirNIF());
					System.out.println("Cliente borrado");

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 3:// cambiar tarifa (NIF) //TODO
				try {
					cc.cambiarTarifaCliente(ld.pedirNIF(), ld.pedirTarifa());
					System.out.println("Tarifa cambiada");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 4:// recuperar datos cliente (NIF)
				Cliente cliente;
				try {
					cliente = cc.recuperarDatosClienteNIF(ld.pedirNIF());
					System.out.println(cliente);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println(e.getMessage());
				}
				break;

			case 5:// recuperar listado clientes
				clientes = cc.recuperarListadoClientes();
				it = clientes.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;
			
			case 6:// recuperar listado clientes entre fechas
				Periodo p = ld.pedirPeriodo();
				clientes = cc.listarListadoClientesFecha(p);
				it = clientes.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
			mostrarOpcionesCliente();
			opcion = ld.pedirNumeroEntero("");

		}
		mostrarOpciones();
	}

	public void mostrarOpcionesFactura() {
		System.out.println("Escoge una opcion");
		System.out.println("1. Emitir una factura para un cliente");
		System.out.println("2. Recuperar los datos de una factura");
		System.out.println("3. Recuperar todas las facturas de un cliente");
		System.out
				.println("4. Recuperar un listado de llamadas de un cliente que fueron realizadas entre dos fechas");
		System.out.println("0. Atras");
	}

	public void escogerOpcionesFactura() {
		List<Factura> facturas;
		Iterator<Factura> it;
		int opcion = ld.pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {

			case 1:// emitir factura
				try {
					cc.emitirFacturaCliente(ld.pedirNIF());
					System.out.println("Factura emitida");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println(e.getMessage());
				}
				break;

			case 2:// recuperar factura (id)
				int id = ld.pedirNumeroEntero("Introduce el id de la factura a buscar");
				Factura fac;
				try {
					fac = cc.recuperarDatosFactura(id);
					System.out.println(fac);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 3:// recuperar listado facturas (NIF)
				try {

					facturas = cc.recuperarListadoFacturasCliente(ld.pedirNIF());
					it = facturas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;
			

			case 4:// recuperar listado facturas (NIF) entre fechas
				try {
					Periodo p = ld.pedirPeriodo();
					facturas = cc.listarListadoFacturasFecha(ld.pedirNIF(), p);
					it = facturas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;

			}
			mostrarOpcionesFactura();
			opcion = ld.pedirNumeroEntero("");
		}
		mostrarOpciones();
	}

	public void mostrarOpcionesLlamada() {
		System.out.println("1. Dar de alta una llamada");
		System.out
				.println("2. Realizar un listado de todas las llamadas de un cliente");
		System.out
				.println("3. Realizar un listado de facturas de un cliente emitidas entre dos fechas");
		System.out.println("0. Atras");
	}

	public void escogerOpcionesLlamada() {
		Iterator<Llamada> it;
		List<Llamada> llamadas;
		int opcion = ld.pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {

			case 1:// a�adir llamada (NIF)

				String NIF = ld.pedirNIF();
				Cliente c;
				try {
					c = cc.recuperarDatosClienteNIF(NIF);
					String telefonoDestino = ld.pedirCadena("Telefono destino:");
					int duracion = ld.pedirNumeroEntero("Duracion(minutos):");
					Llamada llamada = new Llamada(c.getTelefono(),
							telefonoDestino, duracion, c.getTarifa());
					cc.darAltaLlamada(NIF, llamada);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 2:// mostrar listado llamadas (NIF)
				try {

					llamadas = cc.listarLlamadasCliente(ld.pedirNIF());
					it = llamadas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

		

			case 3:// mostrar listado llamadas (NIF) entre fechas
				try {

					llamadas = cc.listarListadoLlamadasFecha(ld.pedirNIF(),ld.pedirPeriodo());
					it = llamadas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
			mostrarOpcionesLlamada();
			opcion = ld.pedirNumeroEntero("");
		}
		mostrarOpciones();
	}
}
