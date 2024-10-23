package hilos;

public class Hilo extends Thread{
	
	private String nombre;
	private Double suma;
	private Controlador syn;
	private boolean terminado;
	
	public Hilo(String nombre, Controlador syn) {
		super();
		this.nombre = nombre;
		this.suma = 0.0;
		this.syn = syn;
		this.terminado = false;
	}
	
	@Override
	public void run() {
		
		
	}
	
	
	

}
