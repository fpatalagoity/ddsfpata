package excepciones;

public class NoSePuedeDesactivarException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSePuedeDesactivarException(String message) {
		super(message);
	}
}
