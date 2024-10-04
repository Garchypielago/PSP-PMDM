package recursos;

public class Ejemplo_Raton {
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton(String nombre, int tiempoAlimentacion) {
	
		super ();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
		}
		
	public void comer() {
		try {
			System.out.printf ("El ratón " +this.nombre+" ha comenzado a alimentarse%n",nombre) ;
			Thread. sleep(tiempoAlimentacion * 1000);
			System.out.printf ("El ratón " +this.nombre+" ha terminado de alimentarse%n",nombre) ;				}catch (InterruptedException e) {
			e.printStackTrace () ;
		}														
	}

	public static void main(String[] args) {
		Ejemplo_Raton fievel = new Ejemplo_Raton("Fievel", 4);
		Ejemplo_Raton jerry = new Ejemplo_Raton("Jerry", 5);
		Ejemplo_Raton pinky = new Ejemplo_Raton("Pinky", 3);
		Ejemplo_Raton mickey = new Ejemplo_Raton("Mickey", 6);
		
		fievel.comer();
		jerry.comer();
		pinky.comer();
		mickey.comer();
	}
		
		
}
		