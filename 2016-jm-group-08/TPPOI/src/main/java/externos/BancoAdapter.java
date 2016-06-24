package externos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.uqbar.geodds.Point;

import com.google.gson.Gson;

import ar.edu.TPPOI.Direccion;
import ar.edu.TPPOI.POI;
import ar.edu.TPPOI.Servicio;
import ar.edu.TPPOI.SucursalBanco;

public class BancoAdapter implements SistemaExternoAdapterInterface {

	BancoExternoInterface bancoExterno;

	public BancoAdapter(BancoExternoInterface unSistemaConsultaDeBancosExterno) {
		bancoExterno = unSistemaConsultaDeBancosExterno;
	}

	public List<POI> buscar(String unTextoLibre) {
		Gson gson = new Gson();
		String json = this.bancoExterno.buscar(unTextoLibre);
		BancoJSON[] bancosJSON = gson.fromJson(json, BancoJSON[].class);
		if (bancosJSON == null) {
			List<POI> listaVaciaDePOIs = new ArrayList<>();
			return listaVaciaDePOIs;
		} else
			return this.generarNuevasSucursales(bancosJSON);
	}

	private List<POI> generarNuevasSucursales(BancoJSON[] unosBancosJSON) {
		List<POI> sucursalBanco = new ArrayList<>();
		Arrays.stream(unosBancosJSON).forEach(unBancoJSON -> sucursalBanco.add(this.nuevaSucursal(unBancoJSON)));
		return sucursalBanco;
	}

	private SucursalBanco nuevaSucursal(BancoJSON unBancoJSON) {
		Point coordenadaSucursalBanco = new Point(unBancoJSON.getX(), unBancoJSON.getY());
		SucursalBanco sucursalBanco = new SucursalBanco(unBancoJSON.getBanco(), unBancoJSON.getSucursal(),
				coordenadaSucursalBanco, new Direccion());
		unBancoJSON.getServicios().remove("");
		unBancoJSON.getServicios().forEach(
				unNombreServicio -> sucursalBanco.agregarServicio(Servicio.nuevoServicioBanco(unNombreServicio)));
		return sucursalBanco;
	}
}
