package thread;

import java.util.*;

public class Ejercicio04_equipos extends Thread{
	
	private ArrayList<Ejercicio04_corredores> equipo ;
	private String nombre;

	public Ejercicio04_equipos(String nombre) {
		super();
		this.equipo = new ArrayList<Ejercicio04_corredores>();
		this.nombre = nombre;
	}
	
	public void add(String nombre) {
		equipo.add(new Ejercicio04_corredores(this.nombre, nombre));
	}
	
	public void run() {
		for (Ejercicio04_corredores c : equipo) {
			try {
				c.start();
				c.join();
			} catch (InterruptedException e) {
			}
		}
		
	}

}
