package excepciones;

public class ListaVaciaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ListaVaciaException(){
		super();
	}
	public ListaVaciaException(String message){
		super(message);
	}

}
