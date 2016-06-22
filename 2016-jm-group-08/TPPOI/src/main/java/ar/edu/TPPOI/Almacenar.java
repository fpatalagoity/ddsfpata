package ar.edu.TPPOI;

public class Almacenar implements Accion{

	public void ejecutar(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		unaTerminal.agregarBusquedaHecha(unaBusqueda);
	}
	
}
