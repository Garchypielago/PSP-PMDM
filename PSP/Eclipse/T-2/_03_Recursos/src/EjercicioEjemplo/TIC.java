package EjercicioEjemplo;

public class TIC extends Thread{
	
	public void run() {
		tic();
	}
	
	public void tic() {
		while(true) {
			try {
				System.out.println("TIC");
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}
