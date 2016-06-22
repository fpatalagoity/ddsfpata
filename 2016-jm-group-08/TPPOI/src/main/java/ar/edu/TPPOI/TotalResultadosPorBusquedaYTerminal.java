package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalResultadosPorBusquedaYTerminal implements Reporte{
	
	List<CantidadPorTerminal> resultadosPorTerminal= new ArrayList<>();
	

	public void registrarBusqueda(BusquedaHecha unaBusqueda, Terminal terminal) {
		if (this.contieneLaTerminal(terminal)){
			this.agregarCantidad(terminal,unaBusqueda);
				}else{
					this.agregarTerminalConCantidadDeResultados(unaBusqueda,terminal);
					}	
	}

	private void agregarTerminalConCantidadDeResultados(BusquedaHecha unaBusqueda, Terminal terminal) {
		CantidadPorTerminal nuevaCantidadPorTerminal= new CantidadPorTerminal();
		nuevaCantidadPorTerminal.setTerminal(terminal);
		nuevaCantidadPorTerminal.agregarResultado(unaBusqueda.cantDeResultados);
		this.resultadosPorTerminal.add(nuevaCantidadPorTerminal);
		
	}

	private void agregarCantidad(Terminal terminal, BusquedaHecha unaBusqueda) {
		resultadosPorTerminal.stream().filter(unR->unR.terminal.equals(terminal)).collect(Collectors.toList()).get(0)
		.agregarResultado(unaBusqueda.cantDeResultados);
		
	}

	private boolean contieneLaTerminal(Terminal terminal) {
		return (this.resultadosPorTerminal.stream().filter(unR->unR.terminal.equals(terminal)) != null);
	}

	@Override
	public Map<LocalDate, Integer> obtenerReporteDeBusquedaPorFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal() {
	return this.resultadosPorTerminal;
	}
}
