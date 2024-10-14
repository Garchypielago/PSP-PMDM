package ejercicios_Thread;

public class Ejercicio05_bomba extends Thread {

	public void run() {
		try {
			for (int i=9; i>=0; i--) {
				this.sleep(1000);
				System.out.println("Cuenta atras: " + i);
			}
			
			System.out.println("EXPLOSION DE LA OSTIA");
		} catch (InterruptedException e) {
			System.out.println("Le salvo Juan Pablo");
		}
	}

}