package ej01;

import java.net.*;
import java.util.Scanner;

public class Cliente01 {

	public static void main(String[] args) throws Exception{
		InetAddress destino= InetAddress.getLocalHost();
		int port=12345;
		byte[] mensaje= new byte[1024];
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce mensaje");
		String texto= sc.nextLine();
		mensaje = texto.getBytes();
		
		DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length,destino,port);
		DatagramSocket socket = new DatagramSocket(34567);
		System.out.println("Enviando Datagrama de longitud : "+mensaje.length);
		System.out.println("Host destino                   : "+destino.getHostName());
		System.out.println("IP destino                     : "+destino.getHostAddress());
		System.out.println("Puerto local del socket        : "+socket.getLocalPort());
		System.out.println("Puerto al que envío            : "+envio.getPort());
		
		socket.send(envio);
		
		
		byte[] buffer = new byte[1024];
		DatagramPacket recibo = new DatagramPacket(buffer,buffer.length);
		System.out.println("\nEsperando respuesta...");
		socket.receive(recibo); //recibo datagrama
		int bytesRec = recibo.getLength();//obtengo numero de bytes
		String paquete= new String(recibo.getData());//obtengo String
		
		//Visualizo info
		System.out.println("numero de bytes recibidos      :"+bytesRec);
		System.out.println("Contenido del Paquete          :" +paquete.trim());
		System.out.println("Puerto origen del mensaje      :"+recibo.getPort());
		System.out.println("IP de origen                   :"+ recibo.getAddress().getHostAddress());
		System.out.println("Puerto destino del mensaje     :"+socket.getLocalPort());
		socket.close();
	}

}
