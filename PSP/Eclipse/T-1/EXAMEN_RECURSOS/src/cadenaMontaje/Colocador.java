package cadenaMontaje;

import java.util.Random;

public class Colocador extends Thread {
	private Productos2 p;
	private int total;

	public Colocador(Productos2 p) {
		this.p = p;
		this.total = 0;
	}

	public void run() {
		while (p.getSeguir()) {
			try {
				int tipo = new Random().nextInt(3) + 1;
				System.out.println("Produciendo tipo " + tipo);
				sleep(new Random().nextInt(250));
				p.colocar(tipo);
				total++;

			} catch (InterruptedException e) {
			}
		}
	}
}
