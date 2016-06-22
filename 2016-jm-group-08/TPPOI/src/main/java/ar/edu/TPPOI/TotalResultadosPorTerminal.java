package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalResultadosPorTerminal implements Reporte{
	
	Map<Terminal,Integer> resultadosPorTerminal=new HashMap<>();

	public void registrarBusqueda(BusquedaHecha unaB, Terminal unaT) {
		if (resultadosPorTerminal.containsKey(unaT)){
			Integer cant = resultadosPorTerminal.get(unaT);
			resultadosPorTerminal.put(unaT, cant+unaB.getCantDeResultados());
		}else{
			resultadosPorTerminal.put(unaT, unaB.getCantDeResultados());
		}
		
	}

	@Override
	public Map<LocalDate, Integer> obtenerReporteDeBusquedaPorFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Terminal,Integer> obtenerReporteDeResultadosPorTerminal(){
		return this.resultadosPorTerminal;
	}

	@Override
	public List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal() {
		// TODO Auto-generated method stub
		return null;
	}
}
