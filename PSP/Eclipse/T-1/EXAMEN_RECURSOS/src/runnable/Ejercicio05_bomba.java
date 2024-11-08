package runnable;

public class Ejercicio05_bomba implements Runnable{

	public void run() {
		try {
			for (int i=9; i>0; i--) {
				Thread.sleep(1000);
				System.out.println("Cuenta atras: " + i);
			}
			System.out.println("EXPLOSION DE LA OSTIA");
		} catch (InterruptedException e) {
			return;
		}
	}

}