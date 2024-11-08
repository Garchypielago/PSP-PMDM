package runnable;

import java.util.*;

public class Ejercicio04_equipos implements Runnable {
	
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
		Thread th = new Thread();
		for (Ejercicio04_corredores c : equipo) {
			try {
				th = new Thread(c);
				th.start();
				th.join();
			} catch (InterruptedException e) {
			}
		}
		
	}

}
