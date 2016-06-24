package ar.edu.TPPOI;

public class Notificar implements Accion {

	long tiempoLimite;
	EnvioDeMail envioDeMail;

	public void ejecutar(BusquedaHecha unaBusqueda, Terminal unaTerminal) {

		if (unaBusqueda.tiempoDeBusqueda > tiempoLimite) {
			envioDeMail.generateAndSendEmail(tiempoLimite, unaBusqueda.tiempoDeBusqueda);
		}
	}

	public void setTiempoLimite(long unTiempoLimite) {
		this.tiempoLimite = unTiempoLimite;
	}

	public Notificar(EnvioDeMail unEnvioDeMail) {
		this.envioDeMail = unEnvioDeMail;
	}

}
