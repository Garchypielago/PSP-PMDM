package hilos;

import java.util.Random;

public class Balsa extends Thread {

	private Playa playa;
	private static int var = 2;
	private int capacidad, rescatados;

	public Balsa(Playa playa) {
		super();
		this.playa = playa;
		this.capacidad = new Random().nextInt(20) + 1;
		this.capacidad += 10 * var++;
		this.rescatados = 0;
	}

	public void run() {
		try {
			while (playa.getNaufragos() > 0) {
				this.sleep(1500);
				sumar(playa.pasar(this.getName(), this.capacidad));
			}
			System.out.println("Balsa "+this.getName()+ " ha salvado "+rescatados+" personas.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sumar(int suma) {
		this.rescatados+=suma;
	}

}
