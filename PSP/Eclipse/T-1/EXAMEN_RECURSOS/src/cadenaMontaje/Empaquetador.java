package cadenaMontaje;

import java.util.Random;

public class Empaquetador extends Thread {
	private Productos2 p;
	private int tipo, total;

	public Empaquetador(Productos2 p, int n) {
		this.p = p;
		this.tipo = n;
		this.total = 0;
	}

	public int getTipo() {
		return tipo;
	}

	public void run() {
		while (p.getSeguir()) {
			try {
				p.coger(this);
				total++;
//				System.out.println("Empaquetando tipo " + tipo);
				sleep(new Random().nextInt(500));

			} catch (InterruptedException e) {
			}
		}
	}
}
