package ar.edu.TPPOI;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

import excepciones.NoExisteServicioAsociadoException;

public class CGPTest {

	Point coordenadaMia;
	ParadaDeColectivo parada114DeCabildoYMonroe;
	CGP cgp1;
	Servicio prestamo, cargaSUBE;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		coordenadaMia = soporteParaTests.miCoordenaAbasto();
		parada114DeCabildoYMonroe = soporteParaTests.paradaDeColectivo114DeCabildoYMonroe();
		prestamo = soporteParaTests.prestamo();
		cargaSUBE = soporteParaTests.cargaSUBE();
		cgp1 = soporteParaTests.cgpComuna5();
	}

	@Test
	public void testPuntoDentroDeLaCGP() {
		Assert.assertTrue(cgp1.estasCercaDe(coordenadaMia));
	}

	@Test
	public void testPuntoAfueraDeLaCGP() {
		Assert.assertFalse(cgp1.estasCercaDe(parada114DeCabildoYMonroe.getCoordenada()));
	}

	@Test
	public void testElCGPDisponibleParaCargarSube() {
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), cargaSUBE));
		Assert.assertTrue(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 15, 10, 30)), cargaSUBE));
	}

	@Test
	public void testCGPNoDispponibleParaCargarSube() {
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 14, 10, 30)), cargaSUBE));
		Assert.assertFalse(cgp1.estaDisponible((LocalDateTime.of(2016, 1, 16, 10, 10, 30)), cargaSUBE));
	}

	@Test(expected = NoExisteServicioAsociadoException.class)
	public void testCgpSinServicioAsociado() {
		cgp1.estaDisponible((LocalDateTime.of(2016, 1, 15, 10, 10, 30)), prestamo);
	}

	@Test
	public void testEncuentraAlmagroEnElCGP5() {
		Assert.assertTrue(cgp1.getZonasQueIncluye().contains("Almagro"));
	}
}