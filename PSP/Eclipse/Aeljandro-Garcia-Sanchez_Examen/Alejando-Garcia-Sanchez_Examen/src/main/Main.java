package main;


import hilos.*;

public class Main {

	public static void main(String[] args) {
		Corral corral = new Corral();
		
		Ave Caponata = new Ave(0, "Caponata", corral);
		Ave Turuleta = new Ave(0, "Turuleta", corral);
		Ave Kiko = new Ave(1, "Kiko", corral);
		
		Dispensador granjero = new Dispensador(corral);
		
		Caponata.start();
		Turuleta.start();
		Kiko.start();
		
		granjero.start();
		

	}

}
