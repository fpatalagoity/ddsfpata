package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AlmacenTerminales {
	
	HashMap<String, List<BusquedaHecha>> historialBusquedas = new HashMap<>();
	
	public void agregarBusquedaHecha(BusquedaHecha unaBusquedaHecha, String idTerminal){
		if (!historialBusquedas.containsKey(idTerminal)){
			historialBusquedas.put(idTerminal, new ArrayList<>());
		}
		List<BusquedaHecha> busquedas = historialBusquedas.get(idTerminal);
		busquedas.add(unaBusquedaHecha);
		historialBusquedas.put(idTerminal, busquedas);
	}
	
	public List<BusquedaHecha> busquedasEnFecha(LocalDate unaFecha){
		List<BusquedaHecha> busquedas = todasLasBusquedas();
		List<BusquedaHecha> busquedasFiltradas = busquedas.stream().filter(
				unaBusqueda -> unaBusqueda.getFecha().isEqual(unaFecha))
				.collect(Collectors.toList());
		return busquedasFiltradas;
	}
	
	private List<BusquedaHecha> todasLasBusquedas(){
		List<BusquedaHecha> busquedas = new ArrayList<>();
		historialBusquedas.values().stream().forEach(
				unaLista -> busquedas.addAll(unaLista));
		return busquedas;
	}
}
