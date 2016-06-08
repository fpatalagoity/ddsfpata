package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public class Notificar extends Accion {
	String nombreAccion="notificar";

	boolean mailEnviado = false;
	
	public void mandarMail(Terminal unaTerminal){
		
		if (this.getActivado()){
			this.mailEnviado = true;
			unaTerminal.seEnvioElMail();
		}
	}
	
	public String getNombreAccion() {
		return nombreAccion;
	}

	public boolean getMailEnviado(){
		return mailEnviado;
	}
	

	public void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados) {
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

	
	@Override
	public Integer resultadosTotales(List<Terminal> terminales) {
		// TODO Auto-generated method stub
		return null;
	}
}
