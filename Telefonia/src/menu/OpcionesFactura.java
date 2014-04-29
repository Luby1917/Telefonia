package menu;

public enum OpcionesFactura  implements Opciones{
	
	ATRAS("Atras"),
	EMITIR("Emitir una factura"),
	BUSCAR("Buscar una factura"),
	LISTAR("Listar facturas "),
	LISTAR_FECHA("Listar facturas que fueron emitidas entre dos fechas");
	
	String descripcion;
	
	private OpcionesFactura(String descripcion){
		this.descripcion = descripcion;
	}
	@Override
	public OpcionesFactura getOpcion(int posicion) {
		return values()[posicion];
	}
	@Override
	public String getDescripcion(){
		return descripcion;
	}
	@Override
	public String listar() {
		String s = "";
		for (int i = 0; i< OpcionesFactura.values().length; i++) {
			OpcionesFactura op= OpcionesFactura.values()[i];
			s+=op.ordinal()+".- "+op.getDescripcion()+"\n";
		}
		return s;
	}
	@Override
	public int size(){
		return values().length;
	}
}

