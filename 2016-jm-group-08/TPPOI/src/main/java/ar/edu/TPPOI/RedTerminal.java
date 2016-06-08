package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RedTerminal {

	private List <Terminal> terminales=new ArrayList<>();
	private List <Accion> accionesRed= new ArrayList<>(); 
	public void agregarTerminal(Terminal unaTerminal){
		terminales.add(unaTerminal);
	}
	public void quitarTerminal (Terminal unaTerminal){
		terminales.remove(unaTerminal);
	}
	public Integer resultadosDeBusquedasTotales(){
		return this.accionesRed.stream().filter(unaA->unaA.getNombreAccion().equals("totalesPorUsuario")).collect(Collectors.toList()).get(0).resultadosTotales(terminales);
	}
}
