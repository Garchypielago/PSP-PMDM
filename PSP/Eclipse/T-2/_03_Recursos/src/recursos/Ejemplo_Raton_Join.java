package recursos;

public class Ejemplo_Raton_Join implements Runnable{
	


	private String nombre;

	private int tiempoAlimentacion;

	public Ejemplo_Raton_Join(String nombre, int tiempoAlimentacion) {
	
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
		
		Ejemplo_Raton_Join fievel = new Ejemplo_Raton_Join("Fievel", 4);		
		Ejemplo_Raton_Join jerry = new Ejemplo_Raton_Join("Jerry", 5);
		Ejemplo_Raton_Join pinky = new Ejemplo_Raton_Join("Pinky", 3);	
		Ejemplo_Raton_Join mickey = new Ejemplo_Raton_Join("Mickey", 6);
		
		new Thread(fievel).start();
		new Thread(jerry).start();
		Thread p = new Thread(pinky);
		p.start();						
		try {
		       p.join();
		   } catch (InterruptedException e) { }	
	
		new Thread(mickey).start();
		System.out.println("FINAL DE PROGRAMA");	   
	}
		
		
}
		