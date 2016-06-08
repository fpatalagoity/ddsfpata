package ar.edu.TPPOI;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.geodds.Point;
import org.uqbar.geodds.Polygon;

import externos.BancoAdapter;
import externos.CGPAdapter;
import externos.CentroDTO;
import externos.ServicioDTO;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SoporteDeInstanciasParaTestsBuilder {

	Point miCoordenaAbasto, coordenadaCercaParada114, coordenadaCercaBancoCiudad, coordenadaStarbucks,
			coordenadaCercaStarbucks, coordenadaSportClub, coordenadaCineAbasto, coordenadaParada114,
			coordenadaBancoCiudad;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Servicio cargaSUBE, prestamo, cortePelo;
	LocalComercial starbucksCoronelDiaz1400, sportClubLibertador7395, cineAbasto;
	BancoExternoParaTest bancoExternoImpostor;
	BancoAdapter bancoAdapter;
	CGPExternoParaTest cgpExternoImpostor;
	CGPAdapter cgpAdapter;
	SucursalBanco bancoCiudadCabildoYCongreso;
	CGP cgpComuna5;
	MapaPOI mapa;
	Terminal terminalAbasto = new Terminal();
	Notificar notificar = new Notificar();
	Almacenar almacenar = new Almacenar();

	public Point miCoordenaAbasto() {
		if (miCoordenaAbasto == null) {
			miCoordenaAbasto = new Point(-58.42059446334839, -34.60421247366349);
		}

		return miCoordenaAbasto;
	}

	public ParadaDeColectivo paradaDeColectivo114DeCabildoYMonroe() {
		if (parada114DeCabildoYMonroe == null) {
			coordenadaParada114 = new Point(-58.459845185279846, -34.558164509672146);
			Direccion direccionParada114 = new Direccion();
			direccionParada114.setCalles("Monroe", "Cabildo");
			parada114DeCabildoYMonroe = new ParadaDeColectivo("114", coordenadaParada114, direccionParada114);
		}

		return parada114DeCabildoYMonroe;
	}

	public Servicio prestamo() {
		if (prestamo == null) {
			prestamo = Servicio.nuevoServicioBanco("prestamo");
		}

		return prestamo;

	}

	public Servicio cargaSUBE() {
		if (cargaSUBE == null) {
			List<Horario> horarios = new ArrayList<>();
			horarios.add(new Horario(DayOfWeek.FRIDAY, LocalTime.of(8, 00), LocalTime.of(13, 00)));
			horarios.add(new Horario(DayOfWeek.FRIDAY, LocalTime.of(15, 00), LocalTime.of(20, 00)));
			cargaSUBE = new Servicio("cargar SUBE", horarios);
		}

		return cargaSUBE;

	}

	public String json() {
		return "[{ 'banco': 'Banco de la Plaza'," + "'x': -35.9338322," + "'y': 72.348353,"
				+ "'sucursal': 'Avellaneda'," + "'gerente': 'Javier Loeschbor',"
				+ "'servicios': [ 'cobro cheques', 'depósitos', 'extracciones', 'transferencias', 'créditos', '', '', '' ]"
				+ "}," + "{  'banco': 'Banco de la Plaza'," + "'x': -35.9345681," + "'y': 72.344546,"
				+ "'sucursal': 'Caballito'," + "'gerente': 'Fabián Fantaguzzi',"
				+ "'servicios': [ 'depósitos', 'extracciones', 'transferencias', 'seguros', '', '', '', '' ]" + "}"
				+ "]";
	}

	public BancoExternoParaTest bancoExternoImpostorMock() {
		/*
		 * bancoExternoImpostor = mock(BancoExternoImpostor.class);
		 * when(bancoExternoImpostor.buscar("Banco de la Plaza",
		 * "extracciones")).thenReturn(this.json()); return
		 * bancoExternoImpostor;
		 */
		return new BancoExternoParaTest();
	}

	public BancoAdapter bancoAdapter() {
		bancoAdapter = new BancoAdapter(bancoExternoImpostorMock());
		return bancoAdapter;

	}

	public List<CentroDTO> crearCentrosDTO() {
		CentroDTO nuevoCGP = new CentroDTO();
		List<CentroDTO> listaDeCGPsExternosParaElAdapter = new ArrayList<CentroDTO>();
		nuevoCGP.director = "Juan";
		nuevoCGP.domicilioCompleto = "Junin 521";
		nuevoCGP.zonas.add("San Cristobal");
		nuevoCGP.zonas.add("Balvanera");
		nuevoCGP.numeroDeComuna = 3;
		nuevoCGP.telefono = "4375-0644/45";
		nuevoCGP.serviciosDTO = crearServiciosDTO();
		listaDeCGPsExternosParaElAdapter.add(nuevoCGP);
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

	public CGPExternoParaTest CGPExternoImpostorMock() {
		cgpExternoImpostor = mock(CGPExternoParaTest.class);
		when(cgpExternoImpostor.buscar("Balvanera")).thenReturn(this.crearCentrosDTO());
		when(cgpExternoImpostor.buscar("Junin")).thenReturn(this.crearCentrosDTO());
		when (cgpExternoImpostor.buscar("San Cristobal")).thenReturn(this.crearCentrosDTO());
		return cgpExternoImpostor;
	}

	public CGPAdapter CGPAdapter() {
		cgpAdapter = new CGPAdapter(CGPExternoImpostorMock());
		return cgpAdapter;

	}

	public SucursalBanco bancoCiudadCabildoYCongreso() {
		if (bancoCiudadCabildoYCongreso == null) {
			coordenadaBancoCiudad = new Point(-58.46362049999999, -34.5545459);
			Direccion direccionBancoCiudad = new Direccion();
			direccionBancoCiudad.setCalles("Cabildo", "Congreso");
			bancoCiudadCabildoYCongreso = new SucursalBanco("Banco Ciudad", "Belgrano", coordenadaBancoCiudad,
					direccionBancoCiudad);
			bancoCiudadCabildoYCongreso.agregarServicio(this.prestamo());
		}

		return bancoCiudadCabildoYCongreso;
	}

	public CGP cgpComuna5() {
		if (cgpComuna5 == null) {
			Direccion direccionCGP = new Direccion("Corrientes", 500);
			List<Point> puntos = new ArrayList<>();
			List<String> zonasCGP5 = new ArrayList<>();
			puntos.add(new Point(-58.411898, -34.597984));
			puntos.add(new Point(-58.426446, -34.597878));
			puntos.add(new Point(-58.433334, -34.602696));
			puntos.add(new Point(-58.430051, -34.615469));
			puntos.add(new Point(-58.427899, -34.622162));
			puntos.add(new Point(-58.412372, -34.620890));
			Polygon poligonoCGP = new Polygon(puntos);
			cgpComuna5 = new CGP("Comuna 5", "Propositos generales", poligonoCGP, direccionCGP);
			cgpComuna5.agregarServicio(cargaSUBE());
			zonasCGP5.add("Almagro");
			cgpComuna5.setZonasQueIncluye(zonasCGP5);
		}

		return cgpComuna5;
	}

	public LocalComercial starbucksCoronelDiaz1400() {
		if (starbucksCoronelDiaz1400 == null) {
			coordenadaStarbucks = new Point(-58.413718, -34.593303);
			LocalTime horaInicio = LocalTime.of(10, 00);
			LocalTime horaFin = LocalTime.of(20, 00);
			List<Horario> horarios2 = new ArrayList<>();
			horarios2.add(new Horario(DayOfWeek.MONDAY, horaInicio, horaFin));
			horarios2.add(new Horario(DayOfWeek.TUESDAY, horaInicio, horaFin));
			horarios2.add(new Horario(DayOfWeek.WEDNESDAY, horaInicio, horaFin));
			horarios2.add(new Horario(DayOfWeek.THURSDAY, horaInicio, horaFin));
			horarios2.add(new Horario(DayOfWeek.FRIDAY, horaInicio, horaFin));
			horarios2.add(new Horario(DayOfWeek.SATURDAY, horaInicio, horaFin));
			Direccion direccionStarbucks = new Direccion("Coronel Diaz", 1400);
			starbucksCoronelDiaz1400 = LocalComercial.nuevoLocalConRubroCafeteria("Starbucks", coordenadaStarbucks,
					horarios2, direccionStarbucks);
		}

		return starbucksCoronelDiaz1400;
	}

	public LocalComercial sportClubLibertador7395() {
		if (sportClubLibertador7395 == null) {
			coordenadaSportClub = new Point(-58.4627205, -34.5436991);
			LocalTime horaInicioGym = LocalTime.of(7, 00);
			LocalTime horaFinGym = LocalTime.of(22, 00);
			List<Horario> horariosGym = new ArrayList<>();
			horariosGym.add(new Horario(DayOfWeek.MONDAY, horaInicioGym, horaFinGym));
			horariosGym.add(new Horario(DayOfWeek.TUESDAY, horaInicioGym, horaFinGym));
			horariosGym.add(new Horario(DayOfWeek.WEDNESDAY, horaInicioGym, horaFinGym));
			horariosGym.add(new Horario(DayOfWeek.THURSDAY, horaInicioGym, horaFinGym));
			horariosGym.add(new Horario(DayOfWeek.FRIDAY, horaInicioGym, horaFinGym));
			horariosGym.add(new Horario(DayOfWeek.SATURDAY, horaInicioGym, horaFinGym));
			Direccion direccionSportClub = new Direccion("Avenida Libertador", 7395);
			sportClubLibertador7395 = LocalComercial.nuevoLocal("SportClub", coordenadaSportClub, 15, horariosGym,
					"Gimnasio", direccionSportClub);
			sportClubLibertador7395.setTag("fitness");
			sportClubLibertador7395.setTag("musculacion");
			sportClubLibertador7395.setTag("spinning");
		}

		return sportClubLibertador7395;
	}

	public LocalComercial cineAbasto() {
		if (cineAbasto == null) {
			coordenadaCineAbasto = new Point(-34.6033055, -58.411887);
			Direccion direccionCineAbasto = new Direccion("Av Corrientes", 3247);
			LocalTime horaInicioCine = LocalTime.of(10, 00);
			LocalTime horaFinCine = LocalTime.of(23, 00);
			List<Horario> horariosCine = new ArrayList<>();
			horariosCine.add(new Horario(DayOfWeek.MONDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.TUESDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.WEDNESDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.THURSDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.FRIDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.SATURDAY, horaInicioCine, horaFinCine));
			horariosCine.add(new Horario(DayOfWeek.SUNDAY, horaInicioCine, horaFinCine));
			cineAbasto = new LocalComercial("cineAbasto", coordenadaCineAbasto, 800, horariosCine, "cine",
					direccionCineAbasto);
		}

		return cineAbasto;
	}

	public MapaPOI mapa() {
		if (mapa == null) {
			mapa = new MapaPOI();
			mapa.agregarPOI(paradaDeColectivo114DeCabildoYMonroe());
			mapa.agregarPOI(bancoCiudadCabildoYCongreso());
			mapa.agregarPOI(cgpComuna5());
			mapa.agregarPOI(starbucksCoronelDiaz1400());
			mapa.agregarPOI(sportClubLibertador7395());
			mapa.agregarSistemaExternoAdapter(bancoAdapter());
			mapa.agregarSistemaExternoAdapter(CGPAdapter());
		}

		return mapa;
	}



}
