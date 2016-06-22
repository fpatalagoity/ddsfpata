package excepciones;

public class YaExisteUnaAccionDeEseTipoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public YaExisteUnaAccionDeEseTipoException(String message) {
		super(message);
	}

}
