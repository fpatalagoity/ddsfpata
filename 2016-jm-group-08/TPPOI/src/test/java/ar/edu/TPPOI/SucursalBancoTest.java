package ar.edu.TPPOI;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import excepciones.NoExisteServicioAsociadoException;

public class SucursalBancoTest {

	LocalComercial cineAbasto;
	Point coordenadaMia, coordenadaCercaBancoCiudad;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	Servicio prestamo;
	Servicio deudas;
	SucursalBanco bancoCiudadCabildo;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		coordenadaMia = soporteParaTests.miCoordenaAbasto();
		coordenadaCercaBancoCiudad = new Point(-58.46362069999999, -34.5545479);

		parada114DeCabildoYMonroe = soporteParaTests.paradaDeColectivo114DeCabildoYMonroe();
		prestamo = soporteParaTests.prestamo();
		deudas = soporteParaTests.deudas();
		bancoCiudadCabildo = soporteParaTests.bancoCiudadCabildoYCongreso();
	}

	@Test
	public void testBancoCiudadCabildoNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(bancoCiudadCabildo.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testBancoCiudadCabildoEstaCercaDeCoordenadaCercaBancoCiudad() {
		Assert.assertTrue(bancoCiudadCabildo.estasCercaDe(coordenadaCercaBancoCiudad));
	}

	@Test
	public void testUnPOIEstaAMenosDe1000MetrosDeOtroPOI() {
		Assert.assertTrue(bancoCiudadCabildo.estasAMenosDeXMetrosDe(1000, parada114DeCabildoYMonroe));
	}

	@Test
	public void testUnPOINoEstaAMenosDe300MetrosDeOtroPOI() {
		Assert.assertFalse(bancoCiudadCabildo.estasAMenosDeXMetrosDe(300, parada114DeCabildoYMonroe));
	}

	@Test
	public void testBancoDisponible() {
		Assert.assertTrue(bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), prestamo));
	}
	@Test (expected = NoExisteServicioAsociadoException.class)
	public void testBancoDisponibleParaServicioNoContenido() {
		bancoCiudadCabildo.estaDisponible((LocalDateTime.of(2016, 1, 14, 10, 10, 30)), deudas);
	}

	@Test
	public void testBancoCiudadPasaASerBancoDeLaCiudad() {
		bancoCiudadCabildo.setNombre("bancoDeLaCiudad");
		Assert.assertTrue(bancoCiudadCabildo.getNombre().equals("bancoDeLaCiudad"));
	}
}