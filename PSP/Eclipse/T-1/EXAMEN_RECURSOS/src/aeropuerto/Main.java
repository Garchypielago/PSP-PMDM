package aeropuerto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pista barajas = new Pista();
		Aeroplano a;
		for (int i=1; i<=20; i++) {
			a = new Aeroplano((int)(Math.random()*10)+1, "Hilo"+i , barajas);
			a.start();
		}
		reloj();

	}
	public static void reloj() {

		Thread reloj = new Thread();
		int contador = 0;
		try {
			while (true) {
				contador++;
				reloj.sleep(1000);
				System.out.println(contador);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
