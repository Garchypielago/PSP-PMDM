package cadenaMontaje;

public class Main {

	public static void main(String[] args) {
		Productos2 cola = new Productos2();

		Colocador p = new Colocador(cola);
		Empaquetador emp1 = new Empaquetador(cola, 1);
		Empaquetador emp2 = new Empaquetador(cola, 2);
		Empaquetador emp3 = new Empaquetador(cola, 3);

		p.start();
		emp1.start();
		emp2.start();
		emp3.start();
		terminar(cola);

	}

	public static  void terminar(Productos2 p) {
		try {
			Thread.sleep(10000);
			System.out.println("Terminado el programa");
			p.setSeguir();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
