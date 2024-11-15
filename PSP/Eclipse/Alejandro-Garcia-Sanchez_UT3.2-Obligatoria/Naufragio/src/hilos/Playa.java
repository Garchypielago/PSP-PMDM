package hilos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Playa {

	private Semaphore miSemaforo;
	private int naufragos;

	public Playa(Semaphore miSemaforo) {
		super();
		this.miSemaforo = miSemaforo;
		this.naufragos = new Random().nextInt(200) + 801;
	}

	public int getNaufragos() {
		return naufragos;
	}

	public int pasar(String nombre, int llevar) {
		int llevados = 0;
		try {
			this.miSemaforo.acquire();
			
			if (this.getNaufragos() <= 0) 
				return llevados;
			
			llevados = recoger(llevar);
			System.out.println("Balsa " + nombre + " ha recogido naufragos, ahora hay: " + this.getNaufragos());
			Thread.sleep(1500);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.miSemaforo.release();
		return llevados;
	}

	public synchronized int recoger(int llevar) {
		if (this.naufragos - llevar < 0) {
			int resta = this.naufragos;
			this.naufragos = 0;
			return resta;
		}
		this.naufragos -= llevar;
		return llevar;
	}

}
