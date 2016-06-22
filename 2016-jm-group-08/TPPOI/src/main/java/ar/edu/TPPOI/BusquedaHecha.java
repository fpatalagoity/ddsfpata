package ar.edu.TPPOI;

public class BusquedaHecha {
	
	String frase;
	Integer cantDeResultados;
	long tiempoDeBusqueda;
	

	public void setFrase(String frase){
		this.frase = frase;
	}
	
	public void setCantDeResultados(Integer cantDeResultados){
		this.cantDeResultados = cantDeResultados;
	}
	
	public void setTiempoDeBusqueda(long tiempoDeBusqueda){
		this.tiempoDeBusqueda = tiempoDeBusqueda;
	}
	
	
	
	public String getFrase(){
		return this.frase;
	}
	
	public Integer getCantDeResultados(){
		return this.cantDeResultados;
	}
	
	public long getTiempoDeBusqueda(){
		return this.tiempoDeBusqueda;
	}
	
	public BusquedaHecha datosDeLaBusqueda(String unTextoLibre,Terminal unaTerminal){
	long tiempoInicio;
	tiempoInicio = System.nanoTime(); 
	cantDeResultados = unaTerminal.getMapa().cantidadDePOIsEncontrados(unTextoLibre);
	tiempoDeBusqueda = System.nanoTime() - tiempoInicio;
	this.setFrase(unTextoLibre);
	this.setCantDeResultados(cantDeResultados);
	this.setTiempoDeBusqueda(tiempoDeBusqueda);
	return this;
	}

}
