package ar.edu.TPPOI;

import externos.BancoExternoInterface;

public class BancoExternoParaTest implements BancoExternoInterface {

	public String buscar(String textoLibre) {

		String[] output = textoLibre.split(",");

		if (output[0].equals("Banco de la Plaza") && output[1].equals("extracciones")) {
			return "[{ 'banco': 'Banco de la Plaza'," + "'x': -35.9338322," + "'y': 72.348353,"
					+ "'sucursal': 'Avellaneda'," + "'gerente': 'Javier Loeschbor',"
					+ "'servicios': [ 'cobro cheques', 'depósitos', 'extracciones', 'transferencias', 'créditos', '', '', '' ]"
					+ "}," + "{  'banco': 'Banco de la Plaza'," + "'x': -35.9345681," + "'y': 72.344546,"
					+ "'sucursal': 'Caballito'," + "'gerente': 'Fabián Fantaguzzi',"
					+ "'servicios': [ 'depósitos', 'extracciones', 'transferencias', 'seguros', '', '', '', '' ]" + "}"
					+ "]";
		}
		return null;
	}
}