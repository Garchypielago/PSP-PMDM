package mispaquetes;

import java.util.concurrent.Semaphore;

public class Cola {
	
	
	Semaphore miSemaforo;

	public Cola(Semaphore miSemaforo) {
		super();
		this.miSemaforo = miSemaforo;
	}
	
	public void pasar(String nombre) {
		
					
		try {
			System.out.println("ESPERANDO semaforo hilo:"+nombre);
			this.miSemaforo.acquire();
			System.out.println("PASANDO semaforo hilo:"+nombre);
			System.out.println("Paso 1");
			Thread.sleep(1000);
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
