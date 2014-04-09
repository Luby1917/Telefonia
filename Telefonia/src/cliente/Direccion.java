package cliente;

import java.io.Serializable;

public class Direccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4826758535931497262L;
	private int codPostal;
	private String provincia;
	private String poblacion;

	public Direccion() {
	}

	public Direccion(int codPostal, String provincia, String poblacion) {
		this.codPostal = codPostal;
		this.provincia = provincia;
		this.poblacion = poblacion;
	}

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "\n\tPoblacion:" + poblacion + "\n\tProvincia:" + provincia
				+ "\n\tCodigo postal:" + codPostal;

	}

}