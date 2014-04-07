package menu;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import programa.CarteraClientes;

import llamadas.Llamada;
import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import excepciones.ObjetoNoEncontrado;
import facturas.Factura;
import fecha.Fecha;

public class CopyOfMenu {

	Scanner in;
	CarteraClientes cc;

	public CopyOfMenu(CarteraClientes cc) {
		this.cc = cc;
		in = new Scanner(System.in);

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
		int opcion = in.nextInt();
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
			opcion = in.nextInt();
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
		System.out.println("0. Atras");
	}

	public void escogerOpcionesCliente() {
		int opcion = in.nextInt();
		while (opcion != 0) {
			switch (opcion) {

			case 1:// a�adir cliente
				Cliente c = pedirDatosCliente();
				cc.darDeAltaCliente(c);
				System.out.println("Nuevo cliente añadido");
				break;

			case 2:// borrar cliente (NIF)
				try {
					cc.borrarCliente(pedirNIF());
					System.out.println("Cliente borrado");

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			case 3:// cambiar tarifa (NIF)
				try {
					cc.cambiarTarifaCliente(pedirNIF(), pedirTarifa());
					System.out.println("Tarifa cambiada");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			case 4:// recuperar datos cliente (NIF)
				Cliente cliente;
				try {
					cliente = cc.recuperarDatosClienteNIF(pedirNIF());
					System.out.println(cliente);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			case 5:// recuperar listado clientes
				List<Cliente> clientes = cc.recuperarListadoClientes();
				Iterator<Cliente> it = clientes.iterator();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
			mostrarOpcionesCliente();
			opcion = in.nextInt();
		}
		mostrarOpciones();
	}

	public void mostrarOpcionesFactura() {
		System.out.println("Escoge una opcion");
		System.out.println("1. Emitir una factura para un cliente");
		System.out.println("2. Recuperar los datos de una factura");
		System.out.println("3. Recuperar todas las facturas de un cliente");
		System.out.println("0. Atras");
	}

	public void escogerOpcionesFactura() {
		int opcion = in.nextInt();
		while (opcion != 0) {
			switch (opcion) {

			case 1:// emitir factura
				try {
					cc.emitirFacturaCliente(pedirNIF());
					System.out.println("Factura emitida");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			case 2:// recuperar factura (id)
				System.out.println("Introduce el id de la factura a buscar");
				int id = in.nextInt();
				Factura fac;
				try {
					fac = cc.recuperarDatosFactura(id);
					System.out.println(fac);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("No existe ninguna factura con este id");
				}
				break;

			case 3:// recuperar listado facturas (NIF)
				try {

					List<Factura> facturas = cc
							.recuperarListadoFacturasCliente(pedirNIF());
					Iterator<Factura> it = facturas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			default:
				System.out.println("Opcion no valida");
				break;

			}
			mostrarOpcionesFactura();
			opcion = in.nextInt();
		}
		mostrarOpciones();
	}

	public void mostrarOpcionesLlamada() {
		System.out.println("1. Dar de alta una llamada");
		System.out
				.println("2. Realizar un listado de todas las llamadas de un cliente");
		System.out.println("0. Atras");
	}

	public void escogerOpcionesLlamada() {
		int opcion = in.nextInt();
		while (opcion != 0) {
			switch (opcion) {

			case 1:// a�adir llamada (NIF)

				String NIF = pedirNIF();
				Cliente c;
				try {
					c = cc.recuperarDatosClienteNIF(NIF);
					System.out.println("Telefono destino:");
					String telefonoDestino = in.next();
					System.out.println("Duracion(minutos):");
					int duracion = in.nextInt();
					Llamada llamada = new Llamada(c.getTelefono(),
							telefonoDestino, duracion, c.getTarifa());
					cc.darAltaLlamada(NIF, llamada);
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			case 2:// mostrar listado llamadas (NIF)
				try {

					List<Llamada> llamadas = cc
							.listarLlamadasCliente(pedirNIF());
					Iterator<Llamada> it = llamadas.iterator();
					while (it.hasNext()) {
						System.out.println(it.next());
					}

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println("Este cliente no existe");
				}
				break;

			default:
				System.out.println("Opcion no valida");
				break;
			}
			mostrarOpcionesLlamada();
			opcion = in.nextInt();
		}
		mostrarOpciones();
	}

	public Cliente pedirDatosCliente() {
		String apellido = "";
		System.out.println("Introduce los datos del cliente");
		System.out.println("Escoja una opcion");
		System.out.println("(1) Particular (2) Empresa");
		int opcion = in.nextInt();

		while (opcion < 1 || opcion > 2) {
			System.out.println("Opcion no valida, vuelva a escoger");
			System.out.println("(1) Particular (2) Empresa");
			opcion = in.nextInt();

		}

		System.out.println("Nombre:");
		String nombre = in.next();

		if (opcion == 1) {
			System.out.println("Apellido:");
			apellido = in.next();
		}
		System.out.println("Telefono:");
		String telefono = in.next();
		System.out.println("NIF:");
		String NIF = in.next();
		System.out.println("Direccion:");
		Direccion direccion = pedirDatosDireccion();
		System.out.println("Correo electronico:");
		String correoE = in.next();
		System.out.println("Tarifa:");
		int tarifa = in.nextInt();

		if (opcion == 1) {
			Particular p = new Particular(nombre, telefono, apellido, NIF,
					direccion, tarifa, correoE);
			return p;

		} else {
			Empresa e = new Empresa(nombre, telefono, NIF, direccion, tarifa,
					correoE);
			return e;
		}
	}

	public Direccion pedirDatosDireccion() {

		System.out.println("Introduce los datos del cliente");
		System.out.println("Provincia:");
		String provincia = in.next();
		System.out.println("Poblacion:");
		String poblacion = in.next();
		System.out.println("Codigo postal:");
		int codPostal = in.nextInt();
		Direccion dir = new Direccion(codPostal, provincia, poblacion);
		return dir;
	}

	public String pedirNIF() {
		System.out.println("Introduce el NIF del cliente");
		System.out.println("NIF:");
		String NIF = in.next();
		return NIF;
	}

	public int pedirTarifa() {
		System.out.println("Escoge la tarifa");
		int tarifa = in.nextInt();
		return tarifa;
	}
	
	public Fecha pedirFecha(){
		int dia = pedirNumeroEntero("Introduce el dia");
		while(dia < 1 || dia > 32){
			System.out.println("Dia incorrecto");
			dia = pedirNumeroEntero("Introduce el dia");
		}
		dia--;
		
		int mes = pedirNumeroEntero("Introduce el mes");
		while(mes < 1 || mes > 13){
			System.out.println("Mes incorrecto");
			mes = pedirNumeroEntero("Introduce el mes");
		}
		mes--;

		int ano = pedirNumeroEntero("Introduce el a�o");
		while(ano < 1999 || ano > 2099){	
			System.out.println("A�o incorrecto");
			ano = pedirNumeroEntero("Introduce el a�o");
		}
		ano--;	
		
		Fecha f = new Fecha ();
		f.setFecha(dia, mes, ano);
		
		return f;
	}

	// TODO desacoplar menu y controlar excepciones entrada de datos. Rehacer menu.

	
	
	
	public String pedirCadena(String mensaje) {
		System.out.println(mensaje);
		String dato="";
		boolean loop = true;
		while (loop) {
			try {
				dato = in.next();
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce una cadena valida");
			}
		}
		return dato;
	}
	
	
	public int pedirNumeroEntero(String mensaje) {
		System.out.println(mensaje);
		int dato=-1;
		boolean loop = true;
		while (loop) {
			try {
				dato = in.nextInt();
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero entero valido");
			}
		}
		return dato;
	}

}