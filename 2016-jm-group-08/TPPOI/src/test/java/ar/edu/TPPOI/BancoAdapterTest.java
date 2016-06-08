package ar.edu.TPPOI;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.uqbar.geodds.Point;

public class BancoAdapterTest {

	SoporteDeInstanciasParaTestsBuilder soporteDeInstanciasParaTestsBuilder;

	@Before
	public void init() {
		soporteDeInstanciasParaTestsBuilder = new SoporteDeInstanciasParaTestsBuilder();
	}

	@Test
	public void testBusquedaConCoincidenciaDevuelveDosSucursalesBanco() {

		SucursalBanco unaSucursalBanco;
		List<POI> listaDePOIs = soporteDeInstanciasParaTestsBuilder.bancoAdapter().buscar("Banco de la Plaza,extracciones");
		Assert.assertEquals(listaDePOIs.size(), 2);
		unaSucursalBanco = (SucursalBanco) listaDePOIs.get(0);
		Assert.assertEquals(unaSucursalBanco.getNombre(), "Banco de la Plaza");
		Assert.assertEquals(unaSucursalBanco.getRubro(), "Bancos");
		Assert.assertEquals(unaSucursalBanco.getRadioCercania(), (Integer) 500);
		Assert.assertEquals(unaSucursalBanco.getCoordenada().toString(), new Point(-35.9338322, 72.348353).toString());
		Assert.assertEquals(unaSucursalBanco.getNombreSucursal(), "Avellaneda");
		unaSucursalBanco = (SucursalBanco) listaDePOIs.get(1);
		Assert.assertEquals(unaSucursalBanco.getNombre(), "Banco de la Plaza");
		Assert.assertEquals(unaSucursalBanco.getRubro(), "Bancos");
		Assert.assertEquals(unaSucursalBanco.getRadioCercania(), (Integer) 500);
		Assert.assertEquals(unaSucursalBanco.getCoordenada().toString(), new Point(-35.9345681, 72.344546).toString());
		Assert.assertEquals(unaSucursalBanco.getNombreSucursal(), "Caballito");
	}

	@Test
	public void testBusquedaSinCoincidenciaDeSucursalesBanco() {
		Assert.assertEquals(soporteDeInstanciasParaTestsBuilder.bancoAdapter().buscar("Banco de la Plaza, ").size(),
				0);
	}

}
