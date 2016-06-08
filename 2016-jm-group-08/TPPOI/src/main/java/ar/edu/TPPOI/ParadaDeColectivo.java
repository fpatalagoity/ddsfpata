package ar.edu.TPPOI;

import java.time.LocalDateTime;
import org.uqbar.geodds.Point;

public class ParadaDeColectivo extends POI {

	public ParadaDeColectivo(String unNombre, Point unaCoordenada, Direccion unaDireccion) {
		this(unNombre, unaCoordenada, 100, unaDireccion);
	}

	public ParadaDeColectivo(String unNombre, Point unaCoordenada, Integer unRadioCercania, Direccion unaDireccion) {
		this.nombre = unNombre;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.direccion = unaDireccion;
		this.rubro = "Transporte";
	}

	public boolean estaDisponible(LocalDateTime unMomento) {
		return true;
	}

	public boolean coincideConAtributo(String unTextoLibre) {
		return this.nombre.equals(unTextoLibre);
	}

	public void actualizar(POI unPOI) {
		this.actualizarDesdeDatos(unPOI.getCoordenada(), unPOI.getRadioCercania(), unPOI.getRubro(),
				unPOI.getDireccion(), unPOI.getTags());
	}

}
