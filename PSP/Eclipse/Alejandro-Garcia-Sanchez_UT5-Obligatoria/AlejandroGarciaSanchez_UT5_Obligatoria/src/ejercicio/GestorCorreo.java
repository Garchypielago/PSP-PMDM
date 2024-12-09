package ejercicio;

import jakarta.mail.Session;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GestorCorreo {

	private Properties misPropiedades;
	private Session miSesion;
	private MiAutorizacion miAutorizacion;

	public GestorCorreo() {
		misPropiedades = System.getProperties();
		miAutorizacion = new MiAutorizacion("da2d1e.2024@gmail.com", "nuzw uevk dwym pxbu");
		setPropiedadeServidorSMTP("da2d1e.2024@gmail.com", "nuzw uevk dwym pxbu");
		miSesion = Session.getInstance(misPropiedades, miAutorizacion);
	}

	private void setPropiedadeServidorSMTP(String usuario, String password) {
		misPropiedades.setProperty("mail.smtp.auth", "true");
		misPropiedades.setProperty("mail.smtp.username", usuario);
		misPropiedades.setProperty("mail.smtp.password", password);
		misPropiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
		misPropiedades.setProperty("mail.smtp.port", "587");
		misPropiedades.setProperty("mail.smtp.starttls.enable", "true");
		misPropiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
	}

	private Transport conectarServidorSMTP() throws NoSuchProviderException {
		return miSesion.getTransport("smtp");
	}

	private Message crearNucleoMensaje(String emisor, String destinatario, String asunto)
			throws AddressException, MessagingException {
		Message miMensaje = new MimeMessage(miSesion);

		miMensaje.setFrom(new InternetAddress(emisor));
		miMensaje.setRecipient(Message.RecipientType.CC, new InternetAddress(destinatario));
		miMensaje.setSubject(asunto);

		return miMensaje;
	}

	private Message crearMensajeTexto(String emisor, String destinatario, String asunto, String texto)
			throws AddressException, MessagingException {
		Message miMensaje = crearNucleoMensaje(emisor, destinatario, asunto);

		MimeBodyPart miMBP = new MimeBodyPart();
		MimeMultipart miMMP = new MimeMultipart();

		miMBP.setContent(texto, "text/html");
		miMMP.addBodyPart(miMBP);
		miMensaje.setContent(miMMP);
		return miMensaje;
	}

	private Message crearMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, String texto,
			File adjunto) throws MessagingException, IOException {
		Message miMensaje = crearNucleoMensaje(emisor, destinatario, asunto);

		MimeBodyPart miMBP = new MimeBodyPart();
		MimeBodyPart miMBPF = new MimeBodyPart();
		MimeMultipart miMMP = new MimeMultipart();

		miMBP.setContent(texto, "text/html");
		miMMP.addBodyPart(miMBP);
		miMBPF.attachFile(adjunto);
		miMMP.addBodyPart(miMBPF);
		miMensaje.setContent(miMMP);

		return miMensaje;
	}

	public void enviarMensajeTexto(String emisor, String destinatario, String asunto, String texto)
			throws AddressException, MessagingException {
		Transport miTransport = conectarServidorSMTP();

		miTransport.send(crearMensajeTexto(emisor, destinatario, asunto, texto));

	}

	public void enviarMensajeTextoConAdjunto(String emisor, String destinatario, String asunto, String texto,
			File adjunto) throws MessagingException, IOException {
//		meter lo necesrio en los argumentos
		Transport miTransport = conectarServidorSMTP();

		miTransport.send(crearMensajeTextoConAdjunto(emisor, destinatario, asunto, texto, adjunto));

	}

}
