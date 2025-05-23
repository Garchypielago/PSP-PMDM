package runnable;

public class Ejercicio01 implements Runnable {
	int a;

	public Ejercicio01(int num) {
		a = num;
	}

	@Override
	public void run() {
		if (a % 2 == 0) {
			pares();
		} else if (a % 2 != 0) {
			impares();
		}
	}

	public void pares() {
		try {
			for (int i = 2; i <= 10; i += 2) {
				Thread.sleep(1000);
				System.out.println(i);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void impares() {
		try {
			for (int i = 1; i <= 10; i += 2) {
				Thread.sleep(1000);
				System.out.println(i);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Ejercicio01 pares = new Ejercicio01(0);
		Ejercicio01 impares = new Ejercicio01(1);

		new Thread(pares).start();
		new Thread(impares).start();

	}

}
