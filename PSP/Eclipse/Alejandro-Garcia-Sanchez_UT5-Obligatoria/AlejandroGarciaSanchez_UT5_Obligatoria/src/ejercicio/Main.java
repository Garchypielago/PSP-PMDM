package ejercicio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import jakarta.mail.MessagingException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorCorreo gestorCorreo = new GestorCorreo();
		Scanner sc = new Scanner(System.in);
		String correo = "da2d1e.2024@gmail.com";

		System.out.println("Introduce destinatario:");
		String destinatario = sc.nextLine();

		System.out.println("Introduce asunto:");
		String asunto = sc.nextLine();

		System.out.println("Introduce mensaje:");
		String mensaje = sc.nextLine();

		Boolean adjunto = null;
		while (adjunto == null) {
			System.out.println("¿Quieres incluir archivo? (SI/NO):");
			String respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("SI"))
				adjunto = true;
			else if (respuesta.equalsIgnoreCase("NO"))
				adjunto = false;
		}

		
//		recojo aqui todos los errores
		try {
			if (adjunto) {
				System.out.println("Introduce ruta del archivo (prueba.txt):");
				File archivo = new File(sc.nextLine());

				gestorCorreo.enviarMensajeTextoConAdjunto(correo, destinatario, asunto, mensaje, archivo);

				System.out.println("Enviado con exito");
			} else {
				gestorCorreo.enviarMensajeTexto(correo, destinatario, asunto, mensaje);
				System.out.println("Enviado con exito");
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
