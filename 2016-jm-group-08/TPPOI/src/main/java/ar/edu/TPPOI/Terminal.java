package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Terminal{
	
	String identificador;//Unico, se usa para identificar a una terminal
	long tiempoLimite;
	Map<LocalDateTime,Integer> busquedasPorFecha=new HashMap<LocalDateTime,Integer>();
	MapaPOI mapa;
	List<Accion> acciones=new ArrayList<>(); 
	public List<Accion> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Accion> acciones) {
		this.acciones = acciones;
	}

	long tiempoQueDemoroLaBusqueda;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	AlmacenTerminales almacen = new AlmacenTerminales();//me parece que el almacen deberia ser estatico
	
	public void agregarBusquedaHecha(BusquedaHecha unaBusqueda){
		busquedasHechas.add(unaBusqueda);
	}
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public void setTiempoLimite(long tiempo){
		this.tiempoLimite = tiempo;
	}
	
	public boolean almacenoBusqueda(){
		return busquedasHechas.size() >= 1;
	}
	
	public void buscar(String unTextoLibre){
		LocalDateTime fechaActual= LocalDateTime.now();
		Integer cantidadDeBusquedasDelDia=busquedasPorFecha.get(fechaActual);
		busquedasPorFecha.put(fechaActual, cantidadDeBusquedasDelDia++);		
		long start = System.nanoTime();
		Integer cantidadDeResultados=this.mapa.buscarDesdeTerminal(unTextoLibre);		
		this.tiempoQueDemoroLaBusqueda = System.nanoTime() - start;
		if (this.superaTiempoLimite()) {
			acciones.stream().filter(unaA->unaA.getNombreAccion().equals("notificar")).collect(Collectors.toList()).get(0).mandarMail(this);
		};
		this.almacenarBusquedaSiEstaActivado(unTextoLibre,this.tiempoQueDemoroLaBusqueda,cantidadDeResultados);
		}
		
	
	private void almacenarBusquedaSiEstaActivado(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados) {
		acciones.stream().filter(unaA->unaA.getNombreAccion().equals("almacenar")).collect(Collectors.toList()).get(0).almacenarBusqueda(unTextoLibre, tiempoQueDemoroLaBusqueda2,cantidadDeResultados,this);;
	}

	public boolean superaTiempoLimite(){
		return this.tiempoQueDemoroLaBusqueda > this.tiempoLimite;	
	}
	
	public Integer obtenerReporteDeBusquedasPorFecha(LocalDateTime unaFecha){
		return acciones.stream().filter(unaA->unaA.getNombreAccion().equals("obtenerReporte")).collect(Collectors.toList()).get(0).cantidadDeBusquedasPorFecha(unaFecha,this);
	}
	public Integer reporteDeResultadosPorBusqueda(String unTextoLibre){
		return acciones.stream().filter(unaA->unaA.getNombreAccion().equals("resultadoPorBusqueda")).collect(Collectors.toList()).get(0).resultadoPorBusqueda(unTextoLibre,this);
	}

	public boolean seEnvioElMail() {
		return true;
		
	}

	
}