package excepciones;

public class ObjetoNoEncontrado extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetoNoEncontrado(){
		super();
	}
	
	public ObjetoNoEncontrado(String message){
		super(message);
	}
	
	
}
