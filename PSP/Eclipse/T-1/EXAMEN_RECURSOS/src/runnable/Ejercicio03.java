package runnable;

public class Ejercicio03 implements Runnable {

	private String equipo, nombre;

	public Ejercicio03(String nombre) {
		super();
		this.equipo = "ESPAÑA";
		this.nombre = nombre;
	}

	public Ejercicio03(String equipo, String nombre) {
		super();
		this.equipo = equipo;
		this.nombre = nombre;
	}

	public void run() {
		correr();
	}

	public void correr() {
		int correr, tiempo;
		try {
			System.out.println(equipo + ": " + nombre + " ha empezado a correr");
			correr = (int) (Math.random() * (1050 - 950) + 950);
//			System.out.println(correr);
			tiempo = correr * 10;
//			System.out.println(tiempo);
			Thread.sleep(tiempo);
			System.out.println(equipo + ": " + nombre + " ha terminado en - " + (double) tiempo / 1000 + "s.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Ejercicio03 pepe = new Ejercicio03("Pepe");
		Ejercicio03 juan = new Ejercicio03("Juan");
		Ejercicio03 vicente = new Ejercicio03("Vicente");
		
		Thread th = new Thread();

		try {
			th = new Thread(pepe);
			th.start();
			th.join();
			th = new Thread(juan);
			th.start();
			th.join();
			th = new Thread(vicente);
			th.start();
			th.join();
		} catch (InterruptedException e) {
		}

	}

}