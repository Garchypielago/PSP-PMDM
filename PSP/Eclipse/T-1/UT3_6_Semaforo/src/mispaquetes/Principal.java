package mispaquetes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Principal {

	public static void main (String args[]) {
		Semaphore miSemaforo = new Semaphore(2);
		Cola micola = new Cola(miSemaforo);
		
		ExecutorService miExecutor = Executors.newFixedThreadPool(4);
		
		for(int i=0; i<10; i++ ) {			
			miExecutor.submit(new Hilo(micola));			
		}
		
		miExecutor.shutdown();
	}
}
