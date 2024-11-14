package hilos;

import java.util.Random;

public class Balsa extends Thread{
	
	private Playa  playa;
	private static int var = 2;
	private int capacidad;
	
	public Balsa(Playa  playa) {
		super();
		this.playa = playa;
		this.capacidad = new Random().nextInt(20)+1;
		this.capacidad += 10 * var++;
	}
	
	public void run() {
		while(playa.getNaufragos()>0) {
			playa.pasar(this.getName());
			
		}
	}
	
}
