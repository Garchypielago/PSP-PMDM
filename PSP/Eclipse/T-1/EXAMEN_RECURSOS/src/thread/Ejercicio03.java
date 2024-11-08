package thread;

public class Ejercicio03 extends Thread {

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
			this.sleep(tiempo);
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

		try {
			pepe.start();
			pepe.join();
			juan.start();
			juan.join();
			vicente.start();
			vicente.join();
		} catch (InterruptedException e) {
		}

	}

}