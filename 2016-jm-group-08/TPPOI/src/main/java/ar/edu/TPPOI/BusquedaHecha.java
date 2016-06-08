package ar.edu.TPPOI;

import java.time.LocalDate;

//Este es el objeto que representa la estructura de la busqueda (frase, cantTotal, tiempo) para almacenar
public class BusquedaHecha {

	String frase;
	int cantidadBusquedas;
	long tiempoQueTardoLaConsulta;
	LocalDate fecha;
	
	public void setFrase(String unaFrase){
		this.frase = unaFrase;
	}
	
	public void setCantDeBusquedas(int cant){
		this.cantidadBusquedas = cant;
	}
	
	public void setTiempoQueTardoLaBusqueda(long unTiempo){
		this.tiempoQueTardoLaConsulta = unTiempo;
	}
	
	public void setFecha(LocalDate unaFecha){
		this.fecha = unaFecha;
	}
	
	public LocalDate getFecha(){
		return this.fecha;
	}
}
