package recursos;

public class Ejemplo_Raton_Grupos extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton_Grupos(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			this.sleep(tiempoAlimentacion * 1000);
			System.out.printf ("El ratón " +this.nombre+" ha terminado de alimentarse%n",nombre) ;
		}catch (InterruptedException e) {			
			//e.printStackTrace () ;
			return;
		}														
	}
	
	@Override
	public void run() {
		System.out.println("Informacion del hilo: " + Thread.currentThread().toString());
		this.comer();		
	}

	public static void main(String[] args) throws InterruptedException {
		
		ThreadGroup grupo = new ThreadGroup("Grupo de hilos");
		
		
		Ejemplo_Raton_Grupos fievel = new Ejemplo_Raton_Grupos("Fievel", 4);
		Thread r1 = new Thread(grupo,fievel);
		Ejemplo_Raton_Grupos jerry = new Ejemplo_Raton_Grupos("Jerry", 5);
		Ejemplo_Raton_Grupos pinky = new Ejemplo_Raton_Grupos("Pinky", 3);
		Thread r3 = new Thread(grupo,pinky);
		Ejemplo_Raton_Grupos mickey = new Ejemplo_Raton_Grupos("Mickey", 6);
		
		r1.start();
		jerry.start();
		r3.start();
		mickey.start();
		
		grupo.interrupt();
	}
		
		
}
		