package menu;

import java.util.Scanner;

import tarifas.FactoriaTarifas;
import tarifas.Tarifa;
import tarifas.TarifasExtraDiaGratis;
import tarifas.TarifasExtraFranjaHoraria;
import tarifas.TipoTarifa;
import carteraclientes.TipoCliente;
import cliente.Cliente;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import fecha.Fecha;
import fecha.Periodo;

public class LectorDatos {
	Scanner in;
	FactoriaTarifas ft;
	
	public LectorDatos(){
		in = new Scanner(System.in);
		ft = new FactoriaTarifas();
	}
	
	public TipoCliente pedirTipoCliente(){
		TipoCliente tipoCliente = null;
		boolean loop = true;
		System.out.println(TipoCliente.listar());
		while (loop){
			int opcion = pedirNumeroEntero("Elige el tipo de cliente");
			try{
			tipoCliente = TipoCliente.values()[opcion];
			loop = false;
			}catch (Exception e) {
				System.out.println("ERROR");
				System.out.println("Opcion incorrecta");
			}
		}
		return tipoCliente;
	}
	
	public Cliente pedirDatosCliente(boolean particular) {
		String apellido = null;
		System.out.println("Introduce los datos del cliente");
		String nombre = pedirCadena("Nombre:");
		if (particular)
			apellido = pedirCadena("Apellido:");
		String telefono = pedirCadena("Telefono:");
		String NIF = pedirCadena("NIF:");
		System.out.println("Direccion:");
		Direccion direccion = pedirDatosDireccion();
		String correoE = pedirCadena("Correo electronico:");
		Tarifa tarifa = pedirTarifa();

		if (particular) 
			return new Particular(nombre, telefono, apellido, NIF, direccion, tarifa, correoE);
		 else 
			return new Empresa(nombre, telefono, NIF, direccion, tarifa, correoE);
		
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

	public TipoTarifa pedirTipoTarifa(int tarifa){//TODO
		TipoTarifa tipoTarifa = null;
		boolean loop;
		switch(tarifa){
		case 0:
			loop = true;
			System.out.println(TarifasExtraFranjaHoraria.listar());
			while (loop){
				int opcion = pedirNumeroEntero("Elige el tipo de tarifa extra");
				try{
					tipoTarifa = TarifasExtraFranjaHoraria.values()[opcion];
					loop = false;
				}catch (Exception e) {
					System.out.println("ERROR");
					System.out.println("Opcion incorrecta");
				}
			}
			break;		
		case 1:
			loop = true;
			System.out.println(TarifasExtraDiaGratis.listar());
			while (loop){
				int opcion = pedirNumeroEntero("Elige el tipo de tarifa extra");
				try{
					tipoTarifa = TarifasExtraDiaGratis.values()[opcion];
					loop = false;
				}catch (Exception e) {
					System.out.println("ERROR");
					System.out.println("Opcion incorrecta");
				}
			}
			break;
		}
		return tipoTarifa;
	}
	
	public Tarifa pedirTarifa() {//TODO 
		TipoTarifa tipoTarifa= null;
		Tarifa tarifa = ft.crearTarifa();
		
		tipoTarifa = pedirTipoTarifa(0);		
		tarifa = ft.anadirTarifaAdicional(tipoTarifa);
		tipoTarifa = pedirTipoTarifa(1);		
		tarifa = ft.anadirTarifaAdicional(tipoTarifa);			
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

		int ano = pedirNumeroEntero("Introduce el a�o");//TODO ortografia
		while (ano < 1999 || ano > 2099) {
			System.out.println("A�o incorrecto");//TODO ortografia
			ano = pedirNumeroEntero("Introduce el a�o");//TODO ortografia
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


