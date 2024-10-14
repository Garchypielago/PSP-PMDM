package ejercicios_Runnable;

public class Ejercicio05_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio05_bomba C4 = new Ejercicio05_bomba();
		Ejercicio05_artificiero Pepe = new Ejercicio05_artificiero();
		
		// todo 
		Thread bomba = new Thread(C4);
		Thread artifi = new Thread(Pepe);
		
		artifi.start();
		bomba.start();
		
		do {
		} while(bomba.isAlive() && artifi.isAlive());
		
		if(bomba.isAlive()) {
			bomba.interrupt();
		} else {
			artifi.interrupt();
		}
		

	}


}
