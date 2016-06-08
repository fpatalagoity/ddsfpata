package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public class ResultadoTotalPorUsuario extends Accion{
	public Integer resultadosTotales(List<Terminal> terminales){
		return terminales.stream().mapToInt(unaT->unaT.busquedasHechas.size()).sum();
	}

	@Override
	public String getNombreAccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mandarMail(Terminal unaTerminal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados,
			Terminal terminal) {
		// TODO Auto-generated method stub
		
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

}
