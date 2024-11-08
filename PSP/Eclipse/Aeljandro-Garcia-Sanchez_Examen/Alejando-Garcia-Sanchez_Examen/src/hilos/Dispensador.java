package hilos;

import java.util.Random;

public class Dispensador extends Thread {

	private Corral corral;

	public Dispensador(Corral corral) {
		super();
		this.corral = corral;
	}

	@Override
	public void run() {
		int random;
		try {
			while (corral.getAve() > 0) {
				this.sleep(new Random().nextInt(101));
				random = new Random().nextInt(2) + 1;
				if (random == 1) {
					System.out.println("Dispensador ha puesto una dosis de Maiz");
					corral.colocar(random);
				}else {
					System.out.println("Dispensador ha puesto una dosis de Trigo");
					corral.colocar(random);
				}
			}
		} catch (InterruptedException e) {
		}
		corral.imprimirFinal();
	}

}
