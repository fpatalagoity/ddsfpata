package ar.edu.TPPOI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class GeneradorDeReportes {
	
	public static Integer generarReportePorFecha(LocalDate unaFecha, List<BusquedaHecha> busquedasHechas){
		Integer cantBusquedas = busquedasHechas.stream()
							  				   .filter(unaBusqueda -> unaBusqueda.getFecha().equals(unaFecha))
							  				   .collect(Collectors.toList())
							  				   .size();
		
		return cantBusquedas;
							  
	}
	
	public static List<Integer> generarReportePorBusqueda(List<BusquedaHecha> busquedasHechas){
		List<Integer> resultadosParciales = busquedasHechas.stream()
														   .map(unaB -> unaB.getCantDeResultados())
														   .collect(Collectors.toList());
		
		return resultadosParciales;
	}
	
	public static Map<Terminal, Integer> generarReportesTotales(List<Terminal> terminales){
		Map<Terminal, Integer> terminalesConResultTotales = new HashMap<>();
		
		terminales.forEach(unaT -> cantTotalPorTerminal(unaT, terminalesConResultTotales));
		
		return terminalesConResultTotales;
	}
	
	private static void cantTotalPorTerminal(Terminal unaTerminal, Map<Terminal, Integer> unDiccionario){
		Integer resultTotal = unaTerminal.generarReportePorBusqueda().stream().mapToInt(Integer::intValue).sum();
		
		unDiccionario.put(unaTerminal, resultTotal);
	}
}
