package gui;

import java.io.Serializable;

import carteraclientes.Modelo;

public interface Vista extends Serializable{
	//Modelo y Controlador
	void setModelo(Modelo m);
	Modelo getModelo();
	void setControlador(Controlador c);
	Controlador getControlador();
	
	//funciones de la ventana
	void crear();
	void mostrar();
	void actualizar();
	
	void seleccionarPestana(int i);
	String getClienteSeleccionado();
	
	void setListaClientes(String[] clientes);
	void setListaFacturas(String[] facturas);
	void setListaLlamadas(String[] llamadas);
		
	//get datos
	String pedirCliente();
	int pedirFactura();
	String pedirLlamada();
	
	//notificar Vista
	void notificarActualizacionClientes(String mensaje);
	void notificarActualizacionFacturas(String mensaje);
	void notificarActualizacionLlamadas(String mensaje);
	


}
