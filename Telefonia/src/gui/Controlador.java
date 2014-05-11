package gui;

import java.io.Serializable;

import carteraclientes.Modelo;

public interface Controlador extends Serializable{
	public void setVista(Vista v);
	public void setModelo(Modelo m);
	public String[] listarClientes();
	public String[] listarFacturas(String NIF);
	public String[] listarLlamadas(String NIF);

}