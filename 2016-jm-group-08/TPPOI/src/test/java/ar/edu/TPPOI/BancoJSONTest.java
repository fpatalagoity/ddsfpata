package ar.edu.TPPOI;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;

import externos.BancoJSON;

public class BancoJSONTest {

	@Test
	public void testConvertirObjetoJSON() {
		Gson gson = new Gson();
		BancoJSON[] bancosJSON = gson.fromJson("[" + "{'banco': 'Banco de la Plaza'," + "'x': -35.9338322,"
				+ "'y': 72.348353," + "'sucursal': 'Avellaneda'," + "'gerente': 'Javier Loeschbor',"
				+ "'servicios': [ 'cobro cheques', 'depósitos', 'extracciones', 'transferencias', 'créditos', '', '', '' ]"
				+ "}" + "]", BancoJSON[].class);
		int size = bancosJSON.length;
		Assert.assertEquals(size, 1);
		Assert.assertEquals(bancosJSON[0].getBanco(), "Banco de la Plaza");
		Assert.assertEquals(bancosJSON[0].getX(), -35, 9338322);
		Assert.assertEquals(bancosJSON[0].getY(), 72, 348353);
		Assert.assertEquals(bancosJSON[0].getSucursal(), "Avellaneda");
		Assert.assertEquals(bancosJSON[0].getGerente(), "Javier Loeschbor");
		Assert.assertEquals(bancosJSON[0].getServicios().size(), 8);
		Assert.assertEquals(bancosJSON[0].getServicios().get(0), "cobro cheques");
		Assert.assertEquals(bancosJSON[0].getServicios().get(1), "depósitos");
		Assert.assertEquals(bancosJSON[0].getServicios().get(2), "extracciones");
		Assert.assertEquals(bancosJSON[0].getServicios().get(3), "transferencias");
		Assert.assertEquals(bancosJSON[0].getServicios().get(4), "créditos");
		Assert.assertEquals(bancosJSON[0].getServicios().get(5), "");
		Assert.assertEquals(bancosJSON[0].getServicios().get(6), "");
		Assert.assertEquals(bancosJSON[0].getServicios().get(7), "");
	}

	@Test
	public void testConvertirDosObjetosJSON() {
		Gson gson = new Gson();
		BancoJSON[] bancosJSON = gson.fromJson("[" + "{'banco': 'Banco de la Plaza'," + "'x': -35.9338322,"
				+ "'y': 72.348353," + "'sucursal': 'Avellaneda'," + "'gerente': 'Javier Loeschbor',"
				+ "'servicios': [ 'cobro cheques', 'depósitos', 'extracciones', 'transferencias', 'créditos', '', '', '' ]"
				+ "}," + "{'banco': 'Banco de la Plaza'," + "'x': -35.9345681," + "'y': 72.344546,"
				+ "'sucursal': 'Caballito'," + "'gerente': 'Fabián Fantaguzzi',"
				+ "'servicios': [ 'depósitos', 'extracciones', 'transferencias', 'seguros', '', '', '', '' ]" + "}"
				+ "]", BancoJSON[].class);
		int size = bancosJSON.length;
		Assert.assertEquals(size, 2);
		Assert.assertEquals(bancosJSON[0].getBanco(), "Banco de la Plaza");
		Assert.assertEquals(bancosJSON[0].getX(), -35, 9338322);
		Assert.assertEquals(bancosJSON[0].getY(), 72, 348353);
		Assert.assertEquals(bancosJSON[0].getSucursal(), "Avellaneda");
		Assert.assertEquals(bancosJSON[0].getGerente(), "Javier Loeschbor");
		Assert.assertEquals(bancosJSON[0].getServicios().size(), 8);
		Assert.assertEquals(bancosJSON[0].getServicios().get(0), "cobro cheques");
		Assert.assertEquals(bancosJSON[0].getServicios().get(1), "depósitos");
		Assert.assertEquals(bancosJSON[0].getServicios().get(2), "extracciones");
		Assert.assertEquals(bancosJSON[0].getServicios().get(3), "transferencias");
		Assert.assertEquals(bancosJSON[0].getServicios().get(4), "créditos");
		Assert.assertEquals(bancosJSON[0].getServicios().get(5), "");
		Assert.assertEquals(bancosJSON[0].getServicios().get(6), "");
		Assert.assertEquals(bancosJSON[0].getServicios().get(7), "");
		Assert.assertEquals(bancosJSON[1].getBanco(), "Banco de la Plaza");
		Assert.assertEquals(bancosJSON[1].getX(), -35, 9345681);
		Assert.assertEquals(bancosJSON[1].getY(), 72, 344546);
		Assert.assertEquals(bancosJSON[1].getSucursal(), "Caballito");
		Assert.assertEquals(bancosJSON[1].getGerente(), "Fabián Fantaguzzi");
		Assert.assertEquals(bancosJSON[1].getServicios().size(), 8);
		Assert.assertEquals(bancosJSON[1].getServicios().get(0), "depósitos");
		Assert.assertEquals(bancosJSON[1].getServicios().get(1), "extracciones");
		Assert.assertEquals(bancosJSON[1].getServicios().get(2), "transferencias");
		Assert.assertEquals(bancosJSON[1].getServicios().get(3), "seguros");
		Assert.assertEquals(bancosJSON[1].getServicios().get(4), "");
		Assert.assertEquals(bancosJSON[1].getServicios().get(5), "");
		Assert.assertEquals(bancosJSON[1].getServicios().get(6), "");
		Assert.assertEquals(bancosJSON[1].getServicios().get(7), "");
	}

}