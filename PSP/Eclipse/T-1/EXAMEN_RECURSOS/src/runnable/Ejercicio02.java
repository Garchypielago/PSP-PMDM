package runnable;

public class Ejercicio02 implements Runnable {
	
	private int BICI = 180, CORRER=42, NADAR=4;
	
	private int v_correr, v_bici, v_nadar;
	private String nombre;

	public Ejercicio02(int v_correr, int v_bici, int v_nadar, String nombre) {
		super();
		this.v_correr = v_correr;
		this.v_bici = v_bici;
		this.v_nadar = v_nadar;
		this.nombre = nombre;
	}

	public void run() {
		correr();
		pedalear();
		nadar();

		System.out.println("El concursante " + nombre + " ha TERMINADO");
	}

	public void correr() {
		try {
			System.out.println("El concursante " + nombre + " ha empezado a correr");
			Thread.sleep(CORRER / v_correr * 1000);
				System.out.println("El concursante " + nombre + " ha terminado de correr");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pedalear() {
		try {
			System.out.println("El concursante " + nombre + " ha empezado a pedalear");
			Thread.sleep(BICI / v_bici * 1000);
				System.out.println("El concursante " + nombre + " ha terminado de pedalear");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nadar() {
		try {
			System.out.println("El concursante " + nombre + " ha empezado a nadar");
			Thread.sleep(NADAR / v_nadar * 1000);
				System.out.println("El concursante " + nombre + " ha terminado de nadar");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Ejercicio02 pepe = new Ejercicio02(6, 20, 1, "Pepe");
		Ejercicio02 juan = new Ejercicio02(7, 18, 2, "Juan");
		Ejercicio02 vicente = new Ejercicio02(6, 30, 1, "Vicente");

		new Thread(pepe).start();
		new Thread(juan).start();
		new Thread(vicente).start();

	}

}