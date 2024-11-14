package hilos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Playa {

	private Semaphore miSemaforo;
	private int naufragos;

	public Playa(Semaphore miSemaforo) {
		super();
		this.miSemaforo = miSemaforo;
		this.naufragos = new Random().nextInt(1000)+1;
	}
	
	public int getNaufragos() {
		return naufragos;
	}

	public void pasar(String nombre) {	
		try {
			
			this.miSemaforo.acquire();
			Thread.sleep(3*1000);
			System.out.println("Paso 2");
			Thread.sleep(1000);
			System.out.println("Paso 3");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SOLTANDO semaforo hilo:"+nombre);
		this.miSemaforo.release();
		
	}

}
