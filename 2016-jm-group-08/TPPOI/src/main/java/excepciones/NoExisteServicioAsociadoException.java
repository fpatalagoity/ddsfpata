package excepciones;

public class NoExisteServicioAsociadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoExisteServicioAsociadoException(String message) {
		super(message);
	}

}
