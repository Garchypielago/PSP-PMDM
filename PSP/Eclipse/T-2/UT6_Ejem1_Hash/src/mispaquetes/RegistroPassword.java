package mispaquetes;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class RegistroPassword {

	private static Scanner sc = new Scanner(System.in);
	
	public String transformarAHash(String cadena, String algoritmo) throws Exception {
		String resultado = null;
		byte[] password, resumen;
		
		password = cadena.getBytes(StandardCharsets.UTF_8);
		
		MessageDigest Myalgoritmo = MessageDigest.getInstance(algoritmo);
		
		Myalgoritmo.reset();
		
		Myalgoritmo.update(password);
		
		resumen = Myalgoritmo.digest();	
		
		// comparar si la password está bien metida
		//Myalgoritmo.isEqual(??, ??)
		
		resultado  = String.format("%064x", new BigInteger(1,resumen));

		
		return resultado;
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		// INTRODUCIR DATOS POR TECLADO
		System.out.print("Introduce la cadena a convertir: ");
		String cadena = sc.nextLine();
		System.out.println("Elige el algoritmo (teclealo):");
		System.out.println("SHA-1");
		System.out.println("SHA-256");
		System.out.println("SHA-512");
		System.out.println("SHA-3");
		System.out.println("MD5");
		String algoritmo = sc.nextLine();
		
		RegistroPassword myRegistroPassword = new RegistroPassword();
		
		String respuesta = myRegistroPassword.transformarAHash(cadena, algoritmo);
		
		System.out.println(respuesta);
	}

}
