package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ObtenerReporte extends Accion {

	
	public Integer cantidadDeBusquedasPorFecha(LocalDateTime fecha, Terminal unaTerminal){
		return unaTerminal.busquedasHechas.stream().filter(unaB->unaB.fecha.equals(fecha)).collect(Collectors.toList()).size();
	}

	@Override
	public String getNombreAccion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados,
			Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer resultadosTotales(List<Terminal> terminales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mandarMail(Terminal terminal) {
		// TODO Auto-generated method stub
		
	}

	
}
