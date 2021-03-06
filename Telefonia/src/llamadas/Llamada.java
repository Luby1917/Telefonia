package  llamadas;



import fecha.Fecha;
import interfaces.InterfazFecha;
import java.io.Serializable;
import tarifas.Tarifa;



public class Llamada implements InterfazFecha, Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8636849668464694134L;
	private String telefonoCliente;
	private String telefonoDestino;
	private Fecha fechaLlamada;
	private int duracion;
	private Tarifa tarifa;
	private int coste;


	public Llamada() {

	}

	public Llamada(String telefonoCliente, String telefonoDestino, int duracion, Tarifa tarifa) {
		this.telefonoCliente = telefonoCliente;
		this.telefonoDestino = telefonoDestino;
		this.fechaLlamada = new Fecha();
		this.duracion = duracion;
		this.tarifa = tarifa;
		this.setCoste(tarifa.getCoste()*duracion);//TODO cambiar la forma de calcular el coste
	}

	
	private int calcularCoste(){
		return tarifa.getCoste()*duracion;
	}
	
	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefono) {
		this.telefonoCliente = telefono;
	}
	public String getTelefonoDestino() {
		return telefonoDestino;
	}

	public void setTelefonoDestino(String telefono) {
		this.telefonoDestino = telefono;
	}
		
	
	public Fecha getFecha() {
		return fechaLlamada;
	}

	public void setFecha(Fecha fecha) {
		this.fechaLlamada = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
		calcularCoste();
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
		calcularCoste();
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
		calcularCoste();
	}

	public String toString(){
		return " Telefono: "+ getTelefonoDestino()+
				"\tFecha: " + getFecha()+
				"\tDuracion: " + getDuracion()+
				"\tTarifa: " + getTarifa()+
				"\tCoste: " + (double)getCoste()/100+
				"\n";
		
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Llamada)) {
			return false;
		}
		Llamada other = (Llamada) obj;
		if (coste != other.coste) {
			return false;
		}
		if (duracion != other.duracion) {
			return false;
		}
		if (fechaLlamada == null) {
			if (other.fechaLlamada != null) {
				return false;
			}
		} else if (!fechaLlamada.equals(other.fechaLlamada)) {
			return false;
		}
		if (tarifa != other.tarifa) {
			return false;
		}
		if (telefonoCliente == null) {
			if (other.telefonoCliente != null) {
				return false;
			}
		} else if (!telefonoCliente.equals(other.telefonoCliente)) {
			return false;
		}
		if (telefonoDestino == null) {
			if (other.telefonoDestino != null) {
				return false;
			}
		} else if (!telefonoDestino.equals(other.telefonoDestino)) {
			return false;
		}
		return true;
	}
	
	
}