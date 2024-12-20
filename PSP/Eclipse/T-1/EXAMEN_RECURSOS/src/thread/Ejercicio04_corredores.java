package thread;

public class Ejercicio04_corredores extends Thread {

	private String equipo, nombre;

	public Ejercicio04_corredores(String equipo, String nombre) {
		super();
		this.equipo = equipo;
		this.nombre = nombre;
	}

	public void run() {
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
}