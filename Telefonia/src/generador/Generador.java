package  generador;

import tarifas.TarifaBasica;
import cliente.Direccion;
import cliente.Empresa;
import cliente.Particular;
import es.uji.www.GeneradorDatosINE;

public class Generador {
	GeneradorDatosINE generador;
	String[] dominios = { "uji.es", "gmail.com", "yahoo.es", "outlook.com"};
	

	public Generador() {
		generador = new GeneradorDatosINE();

	}

	public Direccion generaDireccion() {
		
		generador = new GeneradorDatosINE();
		String provincia = generador.getProvincia(); 
		
		
		String poblacion = generador.getPoblacion(provincia);
		int codPostal = (int) (1000+Math.random() * 51999);
		Direccion dir = new Direccion(codPostal, provincia, poblacion);

		return dir;

	}

	public Particular generaParticular() {
		String nombre = generador.getNombre();
		String telefono = generaTelefono();
		String apellido = generador.getApellido();
		String NIF = generador.getNIF();
		String email = generaEmail(nombre, apellido);
		Direccion dir = generaDireccion();
		TarifaBasica tarifa = new TarifaBasica((int)(1+Math.random()*9));
		Particular p = new Particular(nombre, telefono, apellido, NIF , dir, tarifa, email );
		return p;
	}

	public Empresa generaEmpresa() {
		String nombre = generador.getNombre();
		String telefono = generaTelefono();
		String NIF = generador.getNIF();
		String email = generaEmail(nombre, null);
		Direccion dir = generaDireccion();
		TarifaBasica tarifa = new TarifaBasica((int)(1+Math.random()*9));
		Empresa e = new Empresa(nombre, telefono,  NIF , dir, tarifa, email );
		return e;
	}

	
	private String generaEmail(String nombre, String apellidos) {
		String email = "";
		if (nombre != null) {
			nombre =nombre.toLowerCase().replaceAll(" ", "");
			email += nombre;
		}
		if (apellidos != null) {
			apellidos=apellidos.toLowerCase().replaceAll(" ", "");
			email += apellidos;
		}
		
		return email+"@"+dominios[(int) (Math.random() * dominios.length)];

	}
	
    public String generaTelefono(){
		String telefono= "6";
		for(int i = 0; i < 8; i++){
			telefono += (int)(Math.random()*9);
			
		}
		return telefono;
    	
    }

}
