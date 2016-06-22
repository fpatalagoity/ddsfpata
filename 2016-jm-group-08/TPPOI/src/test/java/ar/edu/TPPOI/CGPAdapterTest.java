package ar.edu.TPPOI;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CGPAdapterTest {
	SoporteDeInstanciasParaTestsBuilder soporteDeInstanciasParaTestsBuilder;

	@Before
	public void init() {
		soporteDeInstanciasParaTestsBuilder = new SoporteDeInstanciasParaTestsBuilder();
	}

	@Test
	public void seAgregaNuevoCGP() {
		CGP unNuevoCGP;
		List<POI> listaDePOIs = soporteDeInstanciasParaTestsBuilder.CGPAdapter().buscar("Balvanera");
		Assert.assertEquals(listaDePOIs.size(), 1);
		unNuevoCGP = (CGP) listaDePOIs.get(0);
		Assert.assertTrue(unNuevoCGP.getZonasQueIncluye().contains("Balvanera"));
		Assert.assertEquals(1, unNuevoCGP.getServicios().size(), 0);
		Assert.assertTrue(unNuevoCGP.coincideConAtributo("asesoramiento"));
		Assert.assertEquals(2, unNuevoCGP.getZonasQueIncluye().size(), 0);
		Assert.assertEquals(1, soporteDeInstanciasParaTestsBuilder.mapa().buscar("Balvanera").size());
		Assert.assertTrue(
				soporteDeInstanciasParaTestsBuilder.mapa().buscar("Balvanera").get(0).getNombre().equals("3"));
		Assert.assertEquals("Junin",
				soporteDeInstanciasParaTestsBuilder.mapa().buscar("Balvanera").get(0).getDireccion().callePrincipal);
		Assert.assertEquals(521,
				soporteDeInstanciasParaTestsBuilder.mapa().buscar("Balvanera").get(0).getDireccion().numero, 0);

	}

}