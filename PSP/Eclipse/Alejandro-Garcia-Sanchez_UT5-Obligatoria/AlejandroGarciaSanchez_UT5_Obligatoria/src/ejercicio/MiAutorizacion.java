package ejercicio;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;

public class MiAutorizacion extends Authenticator{
	
	private String user;
	private String pass;
	public MiAutorizacion(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pass);
	}

}
