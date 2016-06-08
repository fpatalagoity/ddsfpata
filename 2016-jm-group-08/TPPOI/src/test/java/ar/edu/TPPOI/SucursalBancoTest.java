package ar.edu.TPPOI;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class SucursalBancoTest {

	LocalComercial cineAbasto;
	Point coordenadaMia, coordenadaCercaBancoCiudad;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Servicio prestamo;
	SucursalBanco bancoCiudadCabildo;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		coordenadaMia = soporteParaTests.miCoordenaAbasto();
		coordenadaCercaBancoCiudad = new Point(-58.46362069999999, -34.5545479);

		parada114DeCabildoYMonroe = soporteParaTests.paradaDeColectivo114DeCabildoYMonroe();
		prestamo = soporteParaTests.prestamo();
		bancoCiudadCabildo = soporteParaTests.bancoCiudadCabildoYCongreso();
	}

	@Test
	public void testBancoCiudadCabildoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(bancoCiudadCabildo.estaCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoEstaCercaDeCoordenadaCercaBancoCiudad() {
		Assert.assertTrue(bancoCiudadCabildo.estaCercaDe(coordenadaCercaBancoCiudad));
	}

	@Test
	public void testUnPOIEstaAMenosDe1000MetrosDeOtroPOI() {
		Assert.assertTrue(bancoCiudadCabildo.estaAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe));
	}

	@Test
	public void testUnPOINoEstaAMenosDe300MetrosDeOtroPOI() {
		Assert.assertFalse(bancoCiudadCabildo.estaAMenosDeXMetrosDe(300, parada114DeCabildoYMonroe));
	}

	@Test
	public void testBancoDisponible() {
		Assert.assertTrue(bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), prestamo));
	}

	@Test
	public void testBancoCiudadPasaASerBancoDeLaCiudad() {
		bancoCiudadCabildo.setNombre("bancoDeLaCiudad");
		Assert.assertTrue(bancoCiudadCabildo.getNombre().equals("bancoDeLaCiudad"));
	}
}
