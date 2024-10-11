package recursos;

public class Ejemplo_Raton_Runnable implements Runnable{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton_Runnable(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			Thread. sleep(tiempoAlimentacion * 1000);
			System.out.printf ("El ratón " +this.nombre+" ha terminado de alimentarse%n",nombre) ;
		}catch (InterruptedException e) {
			e.printStackTrace () ;
		}														
	}
	
	@Override
	public void run() {
		this.comer();		
	}

	public static void main(String[] args) {
		
		Ejemplo_Raton_Runnable fievel = new Ejemplo_Raton_Runnable("Fievel", 4);		
		Ejemplo_Raton_Runnable jerry = new Ejemplo_Raton_Runnable("Jerry", 5);
		Ejemplo_Raton_Runnable pinky = new Ejemplo_Raton_Runnable("Pinky", 3);	
		Ejemplo_Raton_Runnable mickey = new Ejemplo_Raton_Runnable("Mickey", 6);
		
		new Thread(fievel).start();
		new Thread(jerry).start();
		new Thread(pinky).start();
		new Thread(mickey).start();
	}
		
		
}
		