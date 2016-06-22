package externos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.uqbar.geodds.Polygon;

import ar.edu.TPPOI.CGP;
import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.Horario;
import ar.edu.TPPOI.POI;
import ar.edu.TPPOI.Servicio;

public class CGPAdapter implements SistemaExternoAdapterInterface {

	CGPExternoInterface cgpExterno;

	public CGPAdapter(CGPExternoInterface unSistemaConsultaDeCGPsExterno) {
		cgpExterno = unSistemaConsultaDeCGPsExterno;
	}

	public List<POI> buscar(String unTextoLibre) {
		List<CentroDTO> listaDeCGPsExternos = cgpExterno.buscar(unTextoLibre);
		List<POI> listaCGPEncontrados = new ArrayList<>();

		listaCGPEncontrados = this.generarNuevosCGPs(listaDeCGPsExternos);

		return listaCGPEncontrados;
	}

	private List<POI> generarNuevosCGPs(List<CentroDTO> listaDeCGPsExternos) {
		List<POI> nuevasCGPs = new ArrayList<>();
		listaDeCGPsExternos.stream().forEach(unCGPExterno -> nuevasCGPs.add(crearCGPDeExterno(unCGPExterno)));
		return nuevasCGPs;
	}

	public CGP crearCGPDeExterno(CentroDTO unCGPExterno) {
		CGP nuevoCGP = new CGP(unCGPExterno.numeroDeComuna.toString(), new String(), new Polygon(),
				partirDomicilio(unCGPExterno));
		nuevoCGP.setZonasQueIncluye(unCGPExterno.getZonas());
		Arrays.stream(unCGPExterno.getServiciosDTO())
				.forEach(unServicioDTO -> nuevoCGP.agregarServicio(convertirServicioExterno(unServicioDTO)));
		return nuevoCGP;
	}

	private Servicio convertirServicioExterno(ServicioDTO servicioDTO) {
		String nombre = servicioDTO.getNombreServicio();
		List<Horario> horariosDTO = new ArrayList<>();
		servicioDTO.getRangosServicioDTO().stream()
				.forEach(unRango -> horariosDTO.add(convertirRangosServicioExterno(unRango)));
		Servicio servicioNuevo = new Servicio(nombre, horariosDTO);
		return servicioNuevo;
	}

	private Horario convertirRangosServicioExterno(Integer[] rangoServicioDTO) {
		DayOfWeek diaDeSemana = DayOfWeek.of(rangoServicioDTO[0]);
		LocalTime horaInicio = LocalTime.of(rangoServicioDTO[1], rangoServicioDTO[2]);
		LocalTime horaFin = LocalTime.of(rangoServicioDTO[3], rangoServicioDTO[4]);
		Horario nuevoHorario = new Horario(diaDeSemana, horaInicio, horaFin);
		return nuevoHorario;
	}

	private Direccion partirDomicilio(CentroDTO unCGPExterno) {
		int i=0;
		String [] domicilioVectorizado=unCGPExterno.domicilioCompleto.split(" ");
		String callePrincipalCGPExterno="";
		while (i<domicilioVectorizado.length){
			if (i==0){
				callePrincipalCGPExterno=domicilioVectorizado[0];
				i++;
			}else{callePrincipalCGPExterno=callePrincipalCGPExterno.concat(domicilioVectorizado[i].toString());
			}
			i++;
		}
		Direccion domicilioConvertido=new Direccion(callePrincipalCGPExterno,Integer.parseInt(domicilioVectorizado[domicilioVectorizado.length-1]));
		return domicilioConvertido;
	}
}
