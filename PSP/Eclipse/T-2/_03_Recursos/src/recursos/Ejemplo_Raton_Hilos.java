package recursos;

public class Ejemplo_Raton_Hilos extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton_Hilos(String nombre, int tiempoAlimentacion) {
	
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
			e.printStackTrace () ;
		}														
	}
	
	@Override
	public void run() {
		this.comer();
	}

	public static void main(String[] args) {
		Ejemplo_Raton_Hilos fievel = new Ejemplo_Raton_Hilos("Fievel", 4);
		Ejemplo_Raton_Hilos jerry = new Ejemplo_Raton_Hilos("Jerry", 5);
		Ejemplo_Raton_Hilos pinky = new Ejemplo_Raton_Hilos("Pinky", 3);
		Ejemplo_Raton_Hilos mickey = new Ejemplo_Raton_Hilos("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
//		empiezan a la vez y terminn cuando deben
		
}
		