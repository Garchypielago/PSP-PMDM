package ejercicio;

import java.util.ArrayList;

public class Arbitro {
	private int numeroAl ,turno, nJugadores;
	
	private boolean enJuego;
	
	private ArrayList<String> jugadores;
	
	public Arbitro(int nJugadores, ArrayList<String> jugadores) {
		super();
		this.nJugadores = nJugadores;
		this.numeroAl = 1 + (int)(10*Math.random());
		this.turno = 0;
		this.enJuego = true;
		this.jugadores = jugadores;
		System.out.println("El número es: "+ numeroAl + "\n");
	}

	public String getTurno() {
		if (turno>=nJugadores){
			turno = 0;
		}
		return jugadores.get(turno);
	}
	
	public void comprobarJugada(String id, int num) {
		try {
			System.out.println(id + " dice: " + num);
			if (num == numeroAl) {
				enJuego = false;
				System.out.println(id + " gana, adivinó el número!!!");
			} else {
				this.turno++;
				System.out.println("\tLe toca a " + getTurno());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean enJuego() {
		return enJuego;
	}
	
	
	

}
