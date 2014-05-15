package gui;

import java.io.Serializable;

import carteraclientes.Modelo;

public interface Vista extends Serializable{
	
	void setModelo(Modelo m);
	void setControlador(Controlador c);
	Modelo getModelo();
	Controlador getControlador();
	void crear();
	void mostrar();
	void seleccionarPestana(int i);
	String getClienteSeleccionado();
	void setListaFacturas(String[] facturas);
	void setListaLlamadas(String[] llamadas);
	void actualizar();


}
