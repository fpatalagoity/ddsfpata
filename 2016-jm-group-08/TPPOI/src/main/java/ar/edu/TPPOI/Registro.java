package ar.edu.TPPOI;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Registro {

	Reporte reporte;
	TotalBusquedasPorFecha reporteDeTotalDeBusquedasPorFecha = new TotalBusquedasPorFecha();
	TotalResultadosPorTerminal reporteDeTotalDeResultadosPorTerminal =new TotalResultadosPorTerminal(); 
	
	
	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	public void registrar(BusquedaHecha unaBusqueda, Terminal terminal) {
		this.setReporte(reporteDeTotalDeBusquedasPorFecha);
		reporte.registrarBusqueda(unaBusqueda, terminal);
		this.setReporte(reporteDeTotalDeResultadosPorTerminal);
		reporte.registrarBusqueda(unaBusqueda, terminal);
		
	}

	public Map<LocalDate, Integer> obtenerReporteTotalesBusquedasPorFecha() {
		this.setReporte(reporteDeTotalDeBusquedasPorFecha);
		return reporte.obtenerReporteDeBusquedaPorFecha();
	}

	public List<CantidadPorTerminal> obtenerTotalResultadosPorBusquedaYTerminal() {
	this.setReporte(reporteDeTotalDeResultadosPorTerminal);
	return reporte.obtenerTotalResultadosPorBusquedaYTerminal();
	}
}
