package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BancoExternoImportorTest {

	SoporteDeInstanciasParaTestsBuilder soporteDeInstanciasParaTestsBuilder;

	@Before
	public void init() {
		soporteDeInstanciasParaTestsBuilder = new SoporteDeInstanciasParaTestsBuilder();
	}

	@Test
	public void testBusquedaConCoincidenciaDevuelveJSon() {
		Assert.assertEquals(soporteDeInstanciasParaTestsBuilder.json(), soporteDeInstanciasParaTestsBuilder
				.bancoExternoImpostorMock().buscar("Banco de la Plaza,extracciones"));
	}

	@Test
	public void testBusquedaSinCoincidenciaDevuelveVacio() {
		Assert.assertEquals(null,
				soporteDeInstanciasParaTestsBuilder.bancoExternoImpostorMock().buscar("Banco de la Plaza,extracci"));
	}
}