package menu;


public enum OpcionesCliente  implements Opciones{
	
	ATRAS("Atras"),
	NUEVO("Alta nueva"),
	BORRAR("Borrar cliente"),
	CAMBIAR_TARIFA("Cambiar tarifa cliente"),
	BUSCAR("Buscar cliente"),
	LISTAR_CLIENTES("Listar todos los clientes"),
	LISTAR_CLIETES_FECHA("Listar todos los clientes dados de alta entre dos fechas");
	
	String descripcion;
	
	private OpcionesCliente(String descripcion){
		this.descripcion = descripcion;
	}
	@Override
	public OpcionesCliente getOpcion(int posicion) {
		return values()[posicion];
	}
	@Override
	public String getDescripcion(){
		return descripcion;
	}
	@Override
	public String listar() {
		String s = "";
		for (int i = 0; i< OpcionesCliente.values().length; i++) {
			OpcionesCliente op= OpcionesCliente.values()[i];
			s+=op.ordinal()+".- "+op.getDescripcion()+"\n";
		}
		return s;
	}
	@Override
	public int size(){
		return values().length;
	}
}
