package thread;

import java.util.ArrayList;

public class Ejercicio05_artificiero extends Thread{
	
	public void run() {
		try {
			this.sleep( (int)Math.random() * (10500-9500) + 9500);
			
			System.out.println("Vuelvo a casa");
		} catch (InterruptedException e) {
			System.out.println("Le salvo Juan Pablo");
		}
	}

}
