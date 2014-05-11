package menu;


public enum OpcionesCliente  implements Opciones{
	
	NUEVO("Alta nueva","NUEVO"),
	BORRAR("Borrar cliente","BORRAR"),
	CAMBIAR_TARIFA("Cambiar tarifa cliente","CAMBIAR"),
	BUSCAR("Buscar cliente","BUSCAR"),
	LISTAR_CLIENTES("Listar todos los clientes","LISTAR"),
	LISTAR_CLIETES_FECHA("Listar todos los clientes dados de alta entre dos fechas","LISTAR_FECHA");
	
	String descripcion;
	String action;
	
	private OpcionesCliente(String descripcion, String action){
		this.descripcion = descripcion;
		this.action = action;
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
	public String getAction(){
		return action;
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
