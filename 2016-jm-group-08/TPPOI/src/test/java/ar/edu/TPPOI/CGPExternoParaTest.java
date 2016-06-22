package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;

import externos.CGPExternoInterface;
import externos.CentroDTO;
import externos.ServicioDTO;

public class CGPExternoParaTest implements CGPExternoInterface {

	public List<CentroDTO> buscar(String unTextoLibre) {

		CentroDTO nuevoCGP = new CentroDTO();
		List<CentroDTO> listaDeCGPsExternosParaElAdapter = new ArrayList<CentroDTO>();
		if (unTextoLibre.equals("San Cristobal") || unTextoLibre.equals("Junin") || unTextoLibre.equals("Balvanera")) {
			nuevoCGP.director = "Juan";
			nuevoCGP.domicilioCompleto = "Junin 521";
			nuevoCGP.zonas.add("San Cristobal");
			nuevoCGP.zonas.add("Balvanera");
			nuevoCGP.numeroDeComuna = 3;
			nuevoCGP.telefono = "4375-0644/45";
			nuevoCGP.serviciosDTO = crearServiciosDTO();
			listaDeCGPsExternosParaElAdapter.add(nuevoCGP);
		}
		return listaDeCGPsExternosParaElAdapter;
	}

	public CentroDTO crearCentroDTO() {
		CentroDTO nuevoCGP = new CentroDTO();
		nuevoCGP.director = "Juan";
		nuevoCGP.domicilioCompleto = "Junin 521";
		nuevoCGP.zonas.add("San Cristobal");
		nuevoCGP.zonas.add("Balvanera");
		nuevoCGP.numeroDeComuna = 3;
		nuevoCGP.telefono = "4375-0644/45";
		nuevoCGP.serviciosDTO = crearServiciosDTO();
		return nuevoCGP;
	}

	public ServicioDTO[] crearServiciosDTO() {
		ServicioDTO unServicio = new ServicioDTO();
		unServicio.setNombreServicio("asesoramiento");
		List<Integer[]> rangosServicio = new ArrayList<>();
		rangosServicio.add(new Integer[] { 1, 9, 0, 14, 0 });
		rangosServicio.add(new Integer[] { 2, 9, 0, 14, 0 });
		rangosServicio.add(new Integer[] { 3, 9, 0, 14, 0 });
		rangosServicio.add(new Integer[] { 4, 9, 0, 14, 0 });
		rangosServicio.add(new Integer[] { 5, 9, 0, 14, 0 });
		rangosServicio.add(new Integer[] { 6, 10, 0, 13, 0 });
		unServicio.setRangoServicioDTO(rangosServicio);
		ServicioDTO[] serviciosDTO = new ServicioDTO[] { unServicio };
		return serviciosDTO;
	}

}