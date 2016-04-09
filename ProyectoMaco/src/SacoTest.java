import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class SacoTest {
	
	@org.junit.Test
		public void vendiUnSaco(){		
		Macowins macowins= new Macowins();
		@SuppressWarnings("unused")
		List<Venta> ventas= new ArrayList<>();
		Saco saco1= new Saco();
		Nacional nacional= new Nacional ();
		Sarkany sarkany= new Sarkany();
		saco1.setBotones(10);
		saco1.setMarca(sarkany);
		saco1.setOrigen(nacional);
		saco1.setValorFijo(100);
		macowins.vender(saco1, 1, "12/12/2012");
		Assert.assertEquals(1,macowins.getVentas().size());
	}

	
}
