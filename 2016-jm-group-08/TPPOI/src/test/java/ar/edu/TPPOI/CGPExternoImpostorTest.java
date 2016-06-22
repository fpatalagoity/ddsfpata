package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CGPExternoImpostorTest {
	SoporteDeInstanciasParaTestsBuilder soporteDeInstanciasParaTestsBuilder;

	@Before
	public void init() {
		soporteDeInstanciasParaTestsBuilder = new SoporteDeInstanciasParaTestsBuilder();
	}

	@Test
	public void testBusquedaConCoincidenciaDevuelveCGP3() {
		Assert.assertEquals(1, soporteDeInstanciasParaTestsBuilder.CGPExternoImpostorMock().buscar("Balvanera").size(),
				0);
	}

	@Test
	public void testBusquedaSinCoincidenciaDevuelveVacio() {
		Assert.assertEquals(0, soporteDeInstanciasParaTestsBuilder.CGPExternoImpostorMock().buscar("Almagro").size());
	}

	@Test
	public void testBusquedaDeJuninOK() {
		Assert.assertEquals(1, soporteDeInstanciasParaTestsBuilder.CGPExternoImpostorMock().buscar("Junin").size());
	}

	@Test
	public void testEncuentraSanCristobal() {
		Assert.assertEquals(1,
				soporteDeInstanciasParaTestsBuilder.CGPExternoImpostorMock().buscar("San Cristobal").size());
	}
}