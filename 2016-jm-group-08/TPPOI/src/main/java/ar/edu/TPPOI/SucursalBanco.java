package ar.edu.TPPOI;

import org.apache.commons.lang3.StringUtils;
import org.uqbar.geodds.Point;

public class SucursalBanco extends EmpresaMultiServicios {

	private String nombreSucursal;

	public String getNombreSucursal() {
		return nombreSucursal;
	}

	public SucursalBanco(String unNombre, String unNombreSucursal, Point unaCoordenada, Direccion unaDireccion) {
		this(unNombre, unNombreSucursal, unaCoordenada, 500, unaDireccion);
	}

	private SucursalBanco(String unNombre, String unNombreSucursal, Point unaCoordenada, Integer unRadioCercania,
			Direccion unaDireccion) {
		this.nombre = unNombre;
		this.nombreSucursal = unNombreSucursal;
		this.coordenada = unaCoordenada;
		this.radioCercania = unRadioCercania;
		this.direccion = unaDireccion;
		this.rubro = "Bancos";
	}

	public boolean coincideConAtributo(String unTextoLibre) {
		String[] nombre = unTextoLibre.split(",");
		return this.getNombre().equals(nombre[0]) || this.getNombreSucursal().equals(nombre[0]);
	}

	public boolean esBanco() {
		return true;
	}

	public boolean soyElMismoPOI(POI otroPOI) {

		if (otroPOI.esBanco()) {
			SucursalBanco unaSucursalBanco = (SucursalBanco) otroPOI;
			return (super.soyElMismoPOI(otroPOI)
					&& StringUtils.containsIgnoreCase(unaSucursalBanco.getNombreSucursal(), this.getNombreSucursal()));
		} else {
			return false;
		}

	}
}