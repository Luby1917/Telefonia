package  cliente;

import tarifas.Tarifa;

public class Particular extends Cliente {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = -3486187767684016120L;
	private String apellidos;
	public Particular() {
		super();

	}
	public Particular(String nombre,String telefono, String apellidos, String NIF, Direccion direccion, Tarifa tarifa,	String correoE) {
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
				"\nTarifa: \n"+getTarifa()+
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