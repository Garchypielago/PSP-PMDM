package ej01;

import java.net.*;

public class Servidor01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		byte[] buffer = new byte[1024];
		//asocio el socket al puerto 12345
		DatagramSocket socket = new DatagramSocket(12345);
		
		
		//Esperando
		System.out.println("Esperando Programa.....");
		DatagramPacket recibo = new DatagramPacket(buffer,buffer.length);
		socket.receive(recibo); //recibo datagrama
		int bytesRec = recibo.getLength();//obtengo numero de bytes
		String paquete= new String(recibo.getData());//obtengo String
		
		//Visualizo info
		System.out.println("numero de bytes recibidos :"+bytesRec);
		System.out.println("Contenido del Paquete     :" +paquete.trim());
		System.out.println("Puerto origen del mensaje :"+recibo.getPort());
		System.out.println("IP de origen              :"+ recibo.getAddress().getHostAddress());
		System.out.println("Puerto destino del mensaje:"+socket.getLocalPort());
		
//		envio de menaje
		byte[] mensaje= paquete.trim().toUpperCase().getBytes();
		DatagramPacket envio = new DatagramPacket(mensaje,mensaje.length, recibo.getAddress(),recibo.getPort());
		socket.send(envio);
		System.out.println("MANDADO "+ mensaje);
		socket.close();
		
		}

}
