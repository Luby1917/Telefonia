package gui;

import java.io.Serializable;

import carteraclientes.Modelo;

public interface Vista extends Serializable{
	
	public void setModelo(Modelo m);
	public void setControlador(Controlador c);
	public void crear();
	public void mostrar();


}
