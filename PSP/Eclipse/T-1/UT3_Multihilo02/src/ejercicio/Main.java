package ejercicio;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Juan");
		lista.add("Pepe");
		lista.add("Marina");
		lista.add("Laura");
		
		Arbitro arbitro = new Arbitro(4, lista);
		
		for (String s : lista) {
			new Jugador(s, arbitro).start();
		}
		

	}

}
