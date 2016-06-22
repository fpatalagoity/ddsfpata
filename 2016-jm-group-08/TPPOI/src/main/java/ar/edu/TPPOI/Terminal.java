package ar.edu.TPPOI;

import java.util.List;
import java.util.Map;

import excepciones.NoSePuedeDesactivarException;
import excepciones.YaExisteUnaAccionDeEseTipoException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Terminal {
	
	MapaPOI mapa;
	List<BusquedaHecha> busquedasHechas = new ArrayList<>();
	List<Accion> acciones = new ArrayList<>();
	Registro registro;
	
	//-------------------------------------------------------------
	
	public void setMapa(MapaPOI unMapa){
		this.mapa = unMapa;
	}
	
	public MapaPOI getMapa(){
		return this.mapa;
	}
	
	public void activarAccion(Accion unaAccion){
		if (this.yaExisteAccionDeEseTipo(unaAccion)){
			throw new YaExisteUnaAccionDeEseTipoException("Ya existe una accion de ese tipo") ;
		}
		else{
			this.acciones.add(unaAccion);
		}
	}
	
	public void desactivarAccion(Accion unaAccion){
		if (!acciones.contains(unaAccion)){
			throw new NoSePuedeDesactivarException("No se puede desactivar");
		}
		else{
			this.acciones.remove(unaAccion);
		}
	}
	
	public boolean yaExisteAccionDeEseTipo(Accion unaAccion){
		return acciones.stream().anyMatch(unaA -> unaA.getClass().equals(unaAccion.getClass()));
	}

	
	public void agregarBusquedaHecha(BusquedaHecha unaBusquedaHecha){
		this.busquedasHechas.add(unaBusquedaHecha);
	}
	
	public List<BusquedaHecha> getBusquedasHechas(){
		return this.busquedasHechas;
	}
	
	public List<Accion> getAcciones(){
		return this.acciones;
	}
	
	//--------------------------------------------------------------
	 
	public void buscar(String unTextoLibre){
		BusquedaHecha unaBusqueda = new BusquedaHecha();
		unaBusqueda.datosDeLaBusqueda(unTextoLibre,this);
		this.acciones.forEach(unaAccion -> unaAccion.ejecutar(unaBusqueda, this));
		this.registro.registrar(unaBusqueda,this);
	}
	public Map<LocalDate,Integer> obtenerReporteTotalesBusquedaPorFecha(){
		return this.registro.obtenerReporteTotalesBusquedasPorFecha();
	}
	public List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal(){
		return this.registro.obtenerTotalResultadosPorBusquedaYTerminal();
	}
}
