package ar.edu.TPPOI;

import javax.mail.MessagingException;

public class Notificar implements Accion{


	long tiempoLimite;
	EnvioDeMail envioDeMail;
	
	public void ejecutar(BusquedaHecha unaBusqueda, Terminal unaTerminal){
		
		
		if(unaBusqueda.tiempoDeBusqueda > tiempoLimite){
			try {
				envioDeMail.generateAndSendEmail(tiempoLimite, unaBusqueda.tiempoDeBusqueda);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//-------------------------------------------------------
	
	public void setTiempoLimite(long unTiempoLimite){
		this.tiempoLimite = unTiempoLimite;
	}

	
	public Notificar(EnvioDeMail unEnvioDeMail){
		this.envioDeMail = unEnvioDeMail;
	}
	

 
	
}
