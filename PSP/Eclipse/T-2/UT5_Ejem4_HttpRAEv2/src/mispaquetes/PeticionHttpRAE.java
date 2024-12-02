package mispaquetes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PeticionHttpRAE {
	
	 public int almacenarPagina(String url, String recurso, String path) throws Exception {
		
		String direccion = url + recurso;
		 // Crear el objeto HttpClient, indicando versión del protocolo, así como otros 
		// datos opcionales 
		HttpClient myHttp = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
				.followRedirects(HttpClient.Redirect.NORMAL).build();
		// Crear el objeto HttpRequest, indicando la URI y los parámetros de cabecera de la petición
		HttpRequest myRequest = HttpRequest.newBuilder().GET().uri(URI.create(direccion)).setHeader("User-Agent", "Chrome").build();;
				//.headers("Content-Type", "Text/plain")
		// Realizar la petición a través del método send del HttpClient y asignar las respuestas de la 
		//petición a un objeto HttpResponse
		HttpResponse<Path> myResponse = myHttp.send(myRequest, HttpResponse.BodyHandlers
				.ofFile(Path.of(path)));
				 
		return myResponse.statusCode();
	 }
	 
	 public static void main(String[] args) throws Exception {
					 	
		 	String url = "https://www.rae.es/drae2001/";			
		 	Scanner sc = new Scanner(System.in);
		 	
		 	System.out.println("¿Qué palabra quieres buscar?");
		 	
	        // entrada de una cadena
	        String recurso = sc.nextLine();		 	
		 	
		 	PeticionHttpRAE miPeticion = new PeticionHttpRAE();
		 	String ruta =  "c:/julio/"+recurso+".html";
			try {
				Integer resultado = miPeticion.almacenarPagina(url,recurso,ruta);

			 	System.out.println("descarga finalizada");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	
		
		 	
	 }		 	
}
