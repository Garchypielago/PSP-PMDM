package main;

import java.util.concurrent.*;
import hilos.*;

public class Main {

	public static void main(String[] args) {
		Semaphore miSemaforo = new Semaphore(2);
		Playa playa = new Playa(miSemaforo);

		ExecutorService miExecutor = Executors.newFixedThreadPool(3);

		System.out.println("Numero de naufragos: " + playa.getNaufragos());
		for (int i = 0; i < 3; i++) {
			miExecutor.submit(new Balsa(playa));
		}

		miExecutor.shutdown();
		reloj(playa);

	}

	public static void reloj(Playa playa) {
		int reloj = 0;
		try {
			while (playa.getNaufragos() > 0) {
				System.out.println(reloj++);
				Thread.sleep(1000);
			}
			System.out.println("Hemos tardado en el rescate: "+reloj+" horas");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
