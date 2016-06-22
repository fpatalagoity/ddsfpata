package ar.edu.TPPOI;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excepciones.NoSePuedeDesactivarException;
import excepciones.YaExisteUnaAccionDeEseTipoException;

public class TerminalTest {

	Terminal terminalAbasto;
	MapaPOI mapaInteractivo;
	Notificar accionNotificar;
	Notificar accionNotificar2;
	Almacenar accionAlmacenar;
	Almacenar accionAlmacenar2;
	EnvioDeMail envioDeMail1;
	EnvioDeMail envioDeMail2;
	Reporte reporte1;
	Registro registro1;
	
	@Before
	public void init(){
		SoporteDeInstanciasParaTestsBuilder soporteParaTests = new SoporteDeInstanciasParaTestsBuilder();
		terminalAbasto = soporteParaTests.terminal();
		mapaInteractivo = soporteParaTests.mapa();
		envioDeMail1 = soporteParaTests.envioDeMail();
		envioDeMail2 = soporteParaTests.envioDeMail();
		accionNotificar = soporteParaTests.notificar(envioDeMail1);
		accionNotificar2 = soporteParaTests.notificar(envioDeMail2);
		accionAlmacenar = soporteParaTests.almacenar();
		accionAlmacenar2 = soporteParaTests.almacenar();
		terminalAbasto.setMapa(mapaInteractivo);
		registro1=soporteParaTests.registro();
	
		terminalAbasto.registro=registro1;
		
	}

	
//------------------------------ Tests de Activar/Desactivar ------------------------------	

	//Tests casos felices
	@Test
	public void testActivarUnaAccion(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		
		Assert.assertEquals(true, terminalAbasto.getAcciones().contains(accionNotificar));
	}

	@Test
	public void testDesactivarUnaAccionExistente(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.desactivarAccion(accionNotificar);
		
		Assert.assertEquals(false, terminalAbasto.getAcciones().contains(accionNotificar));
	}
	
	
	//Tests casos especiales
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testQueNoSePuedanAgregarMasDeUnNotificar(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.activarAccion(accionNotificar2);
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQueNoSePuedaSacarUnNotificarSiLaTerminalNoLoTiene(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.desactivarAccion(accionNotificar);
	}
	
	@Test (expected = YaExisteUnaAccionDeEseTipoException.class)
	public void testQueNoSePuedanAgregarMasDeUnAlmacenar(){
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.activarAccion(accionAlmacenar2);
	}
	
	@Test (expected = NoSePuedeDesactivarException.class)
	public void testQueNoSePuedaSacarUnAlmacenarSiLaTerminalNoLoTiene(){
		accionNotificar.setTiempoLimite(1);
		accionNotificar2.setTiempoLimite(1);
		terminalAbasto.desactivarAccion(accionAlmacenar);
	}
	
	
//------------------------------ Tests de Notificar ------------------------------
	@Test
	public void testNotificarCuandoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1);
		terminalAbasto.activarAccion(accionNotificar);
		terminalAbasto.buscar("114");
		Assert.assertEquals(true, envioDeMail1.getMailEnviado());
	}
	
	@Test
	public void testNoNotificaCuandoNoSeExcedeElTiempoLimite(){
		accionNotificar.setTiempoLimite(1000000000); //1 segundo
		terminalAbasto.activarAccion(accionNotificar);
		
		terminalAbasto.buscar("114");
		Assert.assertEquals(false, envioDeMail1.getMailEnviado());
	}
	
	
//------------------------------ Tests de Almacenar ------------------------------
	@Test ()
	public void testAlmacenarResultadosDeBusqueda(){
		
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.buscar("114");
		Assert.assertEquals("114", terminalAbasto.getBusquedasHechas().get(0).getFrase());
		Assert.assertEquals(2, terminalAbasto.getBusquedasHechas().get(0).getCantDeResultados(), 0);

	}
		
	@Test 
	public void testRegistra1Busqueda(){
		terminalAbasto.buscar("114");
		Assert.assertEquals(1,terminalAbasto.obtenerReporteTotalesBusquedaPorFecha().get(LocalDate.now()),0);
	}

	@Test
	public void seAlmacena1Busqueda(){ 
		terminalAbasto.buscar("114");
		Assert.assertEquals(1,terminalAbasto.obtenerTotalResultadosPorBusquedaYTerminal());
	}
	@Test
	public void hay1Resultado(){
		terminalAbasto.activarAccion(accionAlmacenar);
		terminalAbasto.buscar("114");
		Assert.assertEquals(1, terminalAbasto.obtenerTotalResultadosPorBusquedaYTerminal().get(0).cantidadDeResultados);
	}
}
