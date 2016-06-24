package ar.edu.TPPOI;

//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.time.LocalDateTime;

public class EnvioDeMail {

	boolean mailEnviado;

	/*
	 * Properties mailServerProperties; Session getMailSession; MimeMessage
	 * generateMailMessage;
	 */

	public boolean getMailEnviado() {
		return this.mailEnviado;
	}

	public void generateAndSendEmail(long unTiempoLimite,
			long unTiempoDeBusqueda) /*
										 * throws AddressException,
										 * MessagingException
										 */ {
		mailEnviado = true;
		/*
		 * // Step1 System.out.println(
		 * "\n 1 paso ===> Seteando las propiedades del Mail Server...");
		 * mailServerProperties = System.getProperties();
		 * mailServerProperties.put("mail.smtp.port", "587");
		 * mailServerProperties.put("mail.smtp.auth", "true");
		 * mailServerProperties.put("mail.smtp.starttls.enable", "true");
		 * System.out.println(
		 * "Las propiedades del Mail Server han sido seteadas correctamente..."
		 * );
		 * 
		 * // Step2 System.out.println(
		 * "\n\n 2 paso ===> Obteniendo el Mail Session..."); getMailSession =
		 * Session.getDefaultInstance(mailServerProperties, null);
		 * generateMailMessage = new MimeMessage(getMailSession);
		 * generateMailMessage.addRecipient(Message.RecipientType.TO, new
		 * InternetAddress("tppoi.grupo8@gmail.com"));
		 * generateMailMessage.addRecipient(Message.RecipientType.CC, new
		 * InternetAddress("tppoi.grupo8@gmail.com"));
		 * generateMailMessage.setSubject(
		 * "Correo automatico por demora de busqueda"); String emailBody =
		 * "Fecha: " + LocalDateTime.now() + "<br>" +
		 * "--------------------------------------------------------------------------------"
		 * + "<br><br>" + "El tiempo limite de busqueda fue de: " +
		 * Long.toString(unTiempoLimite) + "<br>" +
		 * "El tiempo que demoro la busqueda fue de: " +
		 * Long.toString(unTiempoDeBusqueda) + "<br><br>" +
		 * "--------------------------------------------------------------------------------"
		 * + "<br>Grupo 8."; generateMailMessage.setContent(emailBody,
		 * "text/html"); System.out.println(
		 * "El Mail Session ha sido creado correctamente...");
		 * 
		 * // Step3 System.out.println("\n\n 3 paso ===> Enviando correo...");
		 * Transport transport = getMailSession.getTransport("smtp");
		 * 
		 * // Enter your correct gmail UserID and Password // if you have 2FA
		 * enabled then provide App Specific Password
		 * transport.connect("smtp.gmail.com", "tppoi.grupo8@gmail.com",
		 * "admin.tppoi.grupo8"); transport.sendMessage(generateMailMessage,
		 * generateMailMessage.getAllRecipients()); transport.close();
		 * 
		 * System.out.println("\nCorreo enviado satisfactoriamente.");
		 */
	}
}
