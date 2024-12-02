package mispaquetes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PeticionHttpRAE {
	
	 public StringBuilder getContenido(String direccion) throws IOException {
		StringBuilder respuesta = new StringBuilder();
		 
		URL url = new URL(direccion);			
		HttpURLConnection conexion; 
		conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		conexion.setRequestProperty("Content-Type", "Text/plain");
		conexion.setRequestProperty("charset", "utf-8");
		conexion.setRequestProperty("User-Agent", "Chrome");
		
		int estado = conexion.getResponseCode();
		Reader streamReader;
		if (estado==HttpURLConnection.HTTP_OK) {
			streamReader = new InputStreamReader(conexion.getInputStream());
			int caracter;
			while ((caracter=streamReader.read())!= -1){
				respuesta.append((char)caracter);
			}
		}else {
			System.out.println("Error Http "+ estado);
		}
		conexion.disconnect();
		
		 
		return respuesta;
	 }
	
	 public static void escribirFichero(String path, String contenido) {
		 Path mipath = Paths.get(path);
		 byte[] miBytes = contenido.getBytes();
		 try {
			Files.write(mipath, miBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public static void main(String[] args) {
					 	 			
		 	Scanner sc = new Scanner(System.in);		 	
		 	System.out.println("¿Qué palabra quieres buscar?");		 	
	        // entrada de una cadena
	        String recurso = sc.nextLine();		 	
		 	
		 	PeticionHttpRAE miPeticion = new PeticionHttpRAE();
		 	String url = "https://www.rae.es/drae2001/";
		 	String direccion = url + recurso;
		 	
		 	StringBuilder resultado;
			try {
				resultado = miPeticion.getContenido(direccion);
			 	String ruta =  "c:/julio/"+recurso+".html";
				miPeticion.escribirFichero(ruta, resultado.toString());			 	
			 	System.out.println("descarga finalizada");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		
		 	
	 }		 	
}
