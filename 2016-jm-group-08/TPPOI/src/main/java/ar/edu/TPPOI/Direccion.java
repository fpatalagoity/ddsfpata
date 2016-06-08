package ar.edu.TPPOI;


public class Direccion {
	
	protected String calle1;
	protected String calle2;
	protected Integer numero;
	protected String callePrincipal;
	protected Integer piso;
	protected String letraDepto;
	protected String unidad;
	protected String localidad;
	protected String barrio;
	protected String provincia;
	protected String pais;
	
	public Direccion() {
		//Constructor para instanciar la clase sin atributos
	}
	
	public Direccion(String callePrincipal, Integer numero){
		//constructor que se deberia utilizar siempre
		this.callePrincipal = callePrincipal;
		this.numero = numero;
	}
	
	public void setPrincipal(String callePrincipal, Integer numero){
		this.callePrincipal = callePrincipal;
		this.numero = numero;
	}

	public void setCalles(String calle1, String calle2){
		this.calle1 = calle1;
		this.calle2 = calle2;
	}
	
	public void setDepartamento(Integer piso, String letraDepto){
		this.piso = piso;
		this.letraDepto = letraDepto;
	}
	
	public void setJurisdiccion(String localidad, String barrio, String provincia, String pais){
		this.localidad = localidad;
		this.barrio = barrio;
		this.provincia = provincia;
		this.pais = pais;
	}
	
	public void setUnidad(String unidad){
		this.unidad = unidad;
	}

	public boolean coincideConCalle(String unTextoLibre) {
		return this.callePrincipal.equals(unTextoLibre);
	}
	
}
