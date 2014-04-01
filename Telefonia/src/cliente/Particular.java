package  cliente;

import tarifas.TarifaBasica;

public class Particular extends Cliente {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String apellidos;
	public Particular() {
		super();

	}
	public Particular(String nombre,String telefono, String apellidos, String NIF, Direccion direccion, TarifaBasica tarifa,	String correoE) {
		super(nombre, telefono, NIF,  direccion,  tarifa,  correoE);
		this.apellidos = apellidos;

	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String toString(){
		return  "Nombre: " +getNombre() +
				"\nApellido: " +getApellidos() +
				"\nNIF: "+getNIF()+
				"\nTelefono: "+getTelefono()+
				"\nDireccion: "+getDireccion()+
				"\nCorreo-e: "+getCorreoE()+
				"\nTarifa: "+getTarifa()+
				"\nFecha de alta: "+getFecha()+
				"\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Particular p = (Particular) obj;
		if (   getTelefono().equals(p.getTelefono())
				&& getNIF().equals(p.getNIF())
				&& getCorreoE().equals(p.getCorreoE()) ){
			return true;
			
		}
		return false;
	}

	
	
	
}