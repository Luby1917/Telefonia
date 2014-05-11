package menu;

public interface Opciones {
	Opciones getOpcion(int posicion);
	String getDescripcion();
	String listar();
	int size();
	String getAction();
}
