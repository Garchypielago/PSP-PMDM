package recursos;

public class Ejemplo_Raton_HIlos_Ver_Info extends Thread{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton_HIlos_Ver_Info(String nombre, int tiempoAlimentacion) {
	
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
	    System.out.println(
	    	  	   "Dentro del Hilo  : " + Thread.currentThread().getName() + 
	    	 	   "\n\tPrioridad    : " + Thread.currentThread().getPriority() + 
	    	       "\n\tID           : " + Thread.currentThread().getId() +	  	  
	    	       "\n\tHilos activos: " + Thread.currentThread().activeCount());
		this.comer();
		
	}

	public static void main(String[] args) {
		Ejemplo_Raton_HIlos_Ver_Info fievel = new Ejemplo_Raton_HIlos_Ver_Info("Fievel", 4);
		Ejemplo_Raton_HIlos_Ver_Info jerry = new Ejemplo_Raton_HIlos_Ver_Info("Jerry", 5);
		Ejemplo_Raton_HIlos_Ver_Info pinky = new Ejemplo_Raton_HIlos_Ver_Info("Pinky", 3);
		Ejemplo_Raton_HIlos_Ver_Info mickey = new Ejemplo_Raton_HIlos_Ver_Info("Mickey", 6);
		
		fievel.start();
		jerry.start();
		pinky.start();
		mickey.start();
	}
		
		
}
		