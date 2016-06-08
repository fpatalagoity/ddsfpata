package externos;

import java.util.List;

public class BancoJSON {
	String banco;
	Double x;
	Double y;
	String sucursal;
	String gerente;
	List<String> servicios;

	public String getBanco() {
		return banco;
	}

	public Double getX() {
		return x;
	}

	public Double getY() {
		return y;
	}

	public String getSucursal() {
		return sucursal;
	}

	public String getGerente() {
		return gerente;
	}

	public List<String> getServicios() {
		return servicios;
	}
}
