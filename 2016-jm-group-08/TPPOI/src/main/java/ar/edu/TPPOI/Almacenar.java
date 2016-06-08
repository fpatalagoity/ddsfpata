package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public class Almacenar extends Accion {


	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda, Integer cantidadDeResultados, Terminal unaTerminal){
		BusquedaHecha busqueda=new BusquedaHecha();
		busqueda.setCantDeBusquedas(cantidadDeResultados);
		busqueda.setFrase(unTextoLibre);
		busqueda.setTiempoQueTardoLaBusqueda(tiempoQueDemoroLaBusqueda);
		unaTerminal.busquedasHechas.add(busqueda);
	}

	@Override
	public void mandarMail(Terminal unaTerminal) {
		// TODO Auto-generated method stub
		
	}
	public String getNombreAccion() {
		return "almacenar"; 
	}

	@Override
	public Integer cantidadDeBusquedasPorFecha(LocalDateTime unaFecha, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Integer resultadosTotales(List<Terminal> terminales) {
		// TODO Auto-generated method stub
		return null;
	}
}
