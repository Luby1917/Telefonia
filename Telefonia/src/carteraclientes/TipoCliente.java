package carteraclientes;

public enum TipoCliente {
	PARTICULAR("Particular"),
	EMPRESA("Empresa");

	private String descripcion;
	private TipoCliente(String s) {
		this.descripcion = s;

	}

	public static String listar() {
		String s = "";
		for (TipoCliente t : TipoCliente.values()) {
			s+=t.ordinal()+".- "+t.getDescripcion();		
		}
		return s;
	}
	public String getDescripcion(){
		return descripcion;
	}
}


