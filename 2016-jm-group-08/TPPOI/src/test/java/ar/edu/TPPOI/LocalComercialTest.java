package ar.edu.TPPOI;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class LocalComercialTest {

	Point coordenadaMia, coordenadaCercaStarbucks;
	LocalComercial starbucks;

	@Before
	public void init() {

		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();

		coordenadaMia = soporteParaTests.miCoordenaAbasto();
		coordenadaCercaStarbucks = new Point(-58.414099, -34.593686);

		starbucks = soporteParaTests.starbucksCoronelDiaz1400();
	}

	@Test
	public void testStarbucksNoEstaCercaDeMiCoordenada() {
		Assert.assertFalse(starbucks.estaCercaDe(coordenadaMia));
	}

	@Test
	public void testStarbucksEstaCercaDeCoordenadaCercaStarbucks() {
		Assert.assertTrue(starbucks.estaCercaDe(coordenadaCercaStarbucks));
	}

	@Test
	public void testLocalDisponible() {
		Assert.assertTrue(starbucks.estaDisponible(LocalDateTime.of(2016, 1, 14, 10, 10, 30)));
	}

	@Test
	public void testStarbuckCambiaAStarbacks() {
		Assert.assertTrue(starbucks.getNombre().equals("Starbucks"));
		starbucks.setNombre("starbacks");
		Assert.assertTrue(starbucks.getNombre().equals("starbacks"));
		Assert.assertFalse(starbucks.getNombre().equals("Starbucks"));
	}
}
