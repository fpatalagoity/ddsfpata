package ar.edu.TPPOI;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Accion{
	
	boolean habilitado;
	public boolean puedeNotificar(){
		return false;
	};
	
	public void setActivado(boolean flag){
		this.habilitado = flag;
	}
	public abstract String getNombreAccion();
	public boolean getActivado(){
		return habilitado;
	}	
	
	public abstract void mandarMail(Terminal terminal);



	public abstract void almacenarBusqueda(String unTextoLibre, long tiempoQueDemoroLaBusqueda2, Integer cantidadDeResultados, Terminal terminal);

	public abstract Integer cantidadDeBusquedasPorFecha(LocalDateTime unaFecha, Terminal terminal) ;

	public abstract Integer resultadoPorBusqueda(String unTextoLibre, Terminal terminal);

	public abstract Integer resultadosTotales(List<Terminal> terminales);
	
}