package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalBusquedasPorFecha implements Reporte{
	Map<LocalDate,Integer> busquedasPorFecha=new HashMap<>();
	
	public Map<LocalDate,Integer> obtenerReporteDeBusquedaPorFecha() {
		return  busquedasPorFecha;
	}
	public void registrarBusqueda(BusquedaHecha unaB, Terminal unaT){
	LocalDate fecha= LocalDate.now();

	if (busquedasPorFecha.containsKey(fecha)){
		this.incrementarCantidadVecesBuscadas(fecha);
		
	}else{
		this.inicializarCantidadParaFecha(fecha);
		}
	}
	
	private void inicializarCantidadParaFecha(LocalDate fecha) {
		this.busquedasPorFecha.put(fecha, 1);		
	}

	private void incrementarCantidadVecesBuscadas(LocalDate fecha) {
		Integer veces=this.busquedasPorFecha.get(fecha);
		this.busquedasPorFecha.put(fecha, veces++);
	}
	@Override
	public List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal() {
		// TODO Auto-generated method stub
		return null;
	}	
}
