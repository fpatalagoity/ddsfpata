package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface Reporte {

	void registrarBusqueda(BusquedaHecha unaBusqueda, Terminal terminal);

	Map<LocalDate, Integer> obtenerReporteDeBusquedaPorFecha();

	List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal();

	

}
