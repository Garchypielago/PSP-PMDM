package cadenaMontaje;

public class Productos {

	private int[] lista = { 0, 0, 0 };

	public synchronized void colocar(int numero) {
		if (lista[0] == 0) {
			lista[0] = numero;
			System.out.println("Coloco tipo " + numero + " en la posicion " + 0);
		} else if (lista[1] == 0) {
			lista[1] = numero;
			System.out.println("Coloco tipo " + numero + " en la posicion " + 1);
		} else if (lista[2] == 0) {
			lista[2] = numero;
			System.out.println("Coloco tipo " + numero + " en la posicion " + 2);
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("[" + lista[0] + ", " + lista[1] + ", " + lista[2] + "]");
		notifyAll();
	}

	public synchronized void coger(Empaquetador emp) {
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
			} else {
				wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		boolean condicionNumero = (lista[0] == emp.getTipo() ||lista[1] == emp.getTipo() || lista[2] == emp.getTipo());
//		while (condicionNumero) {}
	}

}
