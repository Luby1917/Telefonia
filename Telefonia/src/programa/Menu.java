package programa;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import llamadas.Llamada;
import tarifas.TarifaBasica;
import carteraclientes.CarteraClientes;
import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import excepciones.ObjetoNoEncontrado;
import excepciones.ObjetoYaExistente;
import facturas.Factura;
import fecha.Fecha;
import fecha.Periodo;

public class Menu {

	Scanner in;
	CarteraClientes cc;

	public Menu(CarteraClientes cc) {
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
		int opcion = pedirNumeroEntero("");
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
			opcion = pedirNumeroEntero("");
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
		int opcion = pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {

			case 1:// a�adir cliente
				Cliente c = pedirDatosCliente();

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
					cc.borrarCliente(pedirNIF());
					System.out.println("Cliente borrado");

				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 3:// cambiar tarifa (NIF) //TODO
				try {
					cc.cambiarTarifaCliente(pedirNIF(), pedirTarifa());
					System.out.println("Tarifa cambiada");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");

					System.out.println(e.getMessage());
				}
				break;

			case 4:// recuperar datos cliente (NIF)
				Cliente cliente;
				try {
					cliente = cc.recuperarDatosClienteNIF(pedirNIF());
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
				Periodo p = pedirPeriodo();
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
			opcion = pedirNumeroEntero("");

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
		int opcion = pedirNumeroEntero("");
		while (opcion != 0) {
			switch (opcion) {

			case 1:// emitir factura
				try {
					cc.emitirFacturaCliente(pedirNIF());
					System.out.println("Factura emitida");
				} catch (ObjetoNoEncontrado e) {
					System.out.println("ERROR");
					System.out.println(e.getMessage());
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

					System.out.println(e.getMessage());
				}
				break;

			case 3:// recuperar listado facturas (NIF)
				try {

					facturas = cc.recuperarListadoFacturasCliente(pedirNIF());
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
					Periodo p = pedirPeriodo();
					facturas = cc.listarListadoFacturasFecha(pedirNIF(), p);
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
			opcion = pedirNumeroEntero("");
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
		int opcion = pedirNumeroEntero("");
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

					System.out.println(e.getMessage());
				}
				break;

			case 2:// mostrar listado llamadas (NIF)
				try {

					llamadas = cc.listarLlamadasCliente(pedirNIF());
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

					llamadas = cc.listarListadoLlamadasFecha(pedirNIF(),pedirPeriodo());
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
			opcion = pedirNumeroEntero("");
		}
		mostrarOpciones();
	}

	public Cliente pedirDatosCliente() {
		String apellido = "";
		System.out.println("Introduce los datos del cliente");
		System.out.println("Escoja una opcion");
		int opcion = pedirNumeroEntero("(1) Particular (2) Empresa");

		while (opcion < 1 || opcion > 2) {
			System.out.println("Opcion no valida, vuelva a escoger");
			opcion = pedirNumeroEntero("(1) Particular (2) Empresa");
		}

		String nombre = pedirCadena("Nombre:");

		if (opcion == 1) {
			apellido = pedirCadena("Apellido:");
		}
		String telefono = pedirCadena("Telefono:");
		String NIF = pedirCadena("NIF:");
		System.out.println("Direccion:");
		Direccion direccion = pedirDatosDireccion();
		String correoE = pedirCadena("Correo electronico:");
		TarifaBasica tarifa = pedirTarifa();

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
		String provincia = pedirCadena("Provincia:");
		String poblacion = pedirCadena("Poblacion:");
		int codPostal = pedirNumeroEntero("Codigo postal:");
		Direccion dir = new Direccion(codPostal, provincia, poblacion);
		return dir;
	}

	public String pedirNIF() {
		System.out.println("Introduce el NIF del cliente");
		String NIF = pedirCadena("NIF:");
		return NIF;
	}

	public TarifaBasica pedirTarifa() {//TODO 
		int coste = pedirNumeroEntero("Escoge la tarifa");
		TarifaBasica tarifa = new TarifaBasica(coste);
		return tarifa;
	}

	public Fecha pedirFecha(String mensaje) {
		System.out.println(mensaje);
		int dia = pedirNumeroEntero("Introduce el dia");
		while (dia < 1 || dia > 32) {
			System.out.println("Dia incorrecto");
			dia = pedirNumeroEntero("Introduce el dia");
		}
		
		int mes = pedirNumeroEntero("Introduce el mes");
		while (mes < 1 || mes > 13) {
			System.out.println("Mes incorrecto");
			mes = pedirNumeroEntero("Introduce el mes");
		}
		mes--;

		int ano = pedirNumeroEntero("Introduce el a�o");
		while (ano < 1999 || ano > 2099) {
			System.out.println("A�o incorrecto");
			ano = pedirNumeroEntero("Introduce el a�o");
		}
		
		Fecha f = new Fecha();
		f.setFecha(dia, mes, ano);
		System.out.println(f);
		return f;
	}

	public Periodo pedirPeriodo() {
		Fecha fIni = pedirFecha("Introduce la fecha inicial del periodo");
		Fecha fDin = pedirFecha("Introduce la fecha final del periodo");
		while (fIni.compareTo(fDin) == 1) {
			System.out.println("La fecha inicial no puede ser superior a la final ");
			fIni = pedirFecha("Introduce la fecha inicial del periodo");;
			fDin = pedirFecha("Introduce la fecha final del periodo");
		}
		return new Periodo(fIni, fDin);
	}

	public String pedirCadena(String mensaje) {
		System.out.println(mensaje);
		String dato = "";
		boolean loop = true;
		while (loop) {
			try {
				dato = in.next();
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce una cadena valida");
				in = new Scanner(System.in);
			}
		}
		return dato;
	}

	public int pedirNumeroEntero(String mensaje) {
		System.out.println(mensaje);
		int dato = -1;
		boolean loop = true;
		while (loop) {
			try {
				dato = in.nextInt();
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero entero valido");
				in = new Scanner(System.in);
			}
		}
		return dato;
	}

} 