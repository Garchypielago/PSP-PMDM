package main;

import java.util.concurrent.*;
import hilos.*;

public class Main {

	public static void main(String[] args) {
		Semaphore miSemaforo = new Semaphore(2);
		Playa playa = new Playa(miSemaforo);
		
		ExecutorService miExecutor = Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3; i++ ) {			
			miExecutor.submit(new Balsa(playa));			
		}
		
		miExecutor.shutdown();

	}

}
