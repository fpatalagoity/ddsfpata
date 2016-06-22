package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

public class CantidadPorTerminal {

	Terminal terminal;
	List<Integer> cantidadDeResultados= new ArrayList<>();
	public Terminal getTerminal() {
		return terminal;
	}
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	public List<Integer> getCantidadDeResultados() {
		return cantidadDeResultados;
	}
	public void setCantidadDeResultados(List<Integer> cantDeResultados) {
		this.cantidadDeResultados = cantDeResultados;
	}
	public void agregarResultado(Integer cantDeResultados) {
		this.cantidadDeResultados.add(cantDeResultados);
		
	}

}
