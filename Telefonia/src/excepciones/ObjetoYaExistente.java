package excepciones;

public class ObjetoYaExistente  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetoYaExistente(){
		super();
	}
	
	public ObjetoYaExistente(String message){
		super(message);
	}
}
