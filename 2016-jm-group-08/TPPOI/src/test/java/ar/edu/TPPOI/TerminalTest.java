package ar.edu.TPPOI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TerminalTest {

	Terminal terminalAbasto=new Terminal ();
	MapaPOI mapaInteractivo;

	@Before
	public void init(){
		
	
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		mapaInteractivo = soporteParaTests.mapa;
		
		terminalAbasto.setMapa(mapaInteractivo);
			List<Accion>accionesAbasto=new ArrayList<>();
			accionesAbasto.add(new Notificar());
			accionesAbasto.add(new Almacenar());
			terminalAbasto.setAcciones(accionesAbasto);
	}		
	
	@Test
	public void testTerminalNotificaCuandoSeExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1); //en nanosegundos
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.seEnvioElMail(), true);
		
	}
	
	@Test
	public void testTerminalNONotificaCuandoNOExcedeElTiempoLimiteDeBusqueda(){
		terminalAbasto.setTiempoLimite(1000000000); // = 1 segundo
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.seEnvioElMail(), false);
		
	}
	
	@Test
	public void testTerminalAlmacenaLosResultadosDeLasBusquedas(){
		terminalAbasto.setTiempoLimite(1000000000);
		terminalAbasto.buscar("114");
		Assert.assertEquals(terminalAbasto.busquedasHechas.stream().filter(unaB->unaB.frase.equals("114")).collect(Collectors.toList()).size(),1);
	}
}
