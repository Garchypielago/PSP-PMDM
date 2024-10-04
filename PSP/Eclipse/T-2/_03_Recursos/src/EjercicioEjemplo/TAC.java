package EjercicioEjemplo;

public class TAC extends Thread {

	public void run() {
		tac();
	}

	public void tac() {
		try {
			this.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		while (true) {
			try {
				System.out.println("TAC");
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
