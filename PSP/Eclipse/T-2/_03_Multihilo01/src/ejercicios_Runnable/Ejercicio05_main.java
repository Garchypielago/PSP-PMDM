package ejercicios_Runnable;

public class Ejercicio05_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio05_bomba C4 = new Ejercicio05_bomba();
		Ejercicio05_artificiero Pepe = new Ejercicio05_artificiero();
		
		// todo 
		new Thread(C4).start();
		new Thread(Pepe).start();
		
		do {
		} while(C4.isAlive() && Pepe.isAlive());
		
		if(C4.isAlive()) {
			C4.interrupt();
		} else {
			Pepe.interrupt();
		}
		

	}


}
