package cadenaMontaje;

public class Productos2 {

	private int[] lista = { 0, 0, 0 };
	private boolean seguir = true;

	public synchronized boolean getSeguir() {
		notifyAll();
		return seguir;
	}

	public void setSeguir() {
		this.seguir = false;
	}

	public synchronized void colocar(int numero) {
		while (lista[0] != 0 && lista[1] != 0 && lista[2] != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (this.getSeguir()) {
			if (lista[0] == 0) {
				lista[0] = numero;
				System.out.println("Coloco tipo " + numero + " en la posicion " + 0);
			} else if (lista[1] == 0) {
				lista[1] = numero;
				System.out.println("Coloco tipo " + numero + " en la posicion " + 1);
			} else if (lista[2] == 0) {
				lista[2] = numero;
				System.out.println("Coloco tipo " + numero + " en la posicion " + 2);
			}

			System.out.println("[" + lista[0] + ", " + lista[1] + ", " + lista[2] + "]");
			notify();
		}
	}

	public synchronized void coger(Empaquetador emp) {
//		No puedo sacar la condicion por uqe se pone y no se acualiza
		while (!(lista[0] != 0 || lista[1] != 0 || lista[2] != 0)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.getSeguir()) {
			try {
				if (lista[0] == emp.getTipo()) {
					lista[0] = 0;
					emp.sleep(100);
					System.out.println("Recogido tipo " + emp.getTipo());
					System.out.println("[" + lista[0] + ", " + lista[1] + ", " + lista[2] + "]");
					notifyAll();
				} else if (lista[1] == emp.getTipo()) {
					lista[1] = 0;
					emp.sleep(100);
					System.out.println("Recogido tipo " + emp.getTipo());
					System.out.println("[" + lista[0] + ", " + lista[1] + ", " + lista[2] + "]");
					notifyAll();
				} else if (lista[2] == emp.getTipo()) {
					lista[2] = 0;
					emp.sleep(100);
					System.out.println("Recogido tipo " + emp.getTipo());
					System.out.println("[" + lista[0] + ", " + lista[1] + ", " + lista[2] + "]");
					notifyAll();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}