package ejercicios_Runnable;

import java.util.ArrayList;

public class Ejercicio05_artificiero implements Runnable{
	
	public void run() {
		try {
			Thread.sleep( (int)Math.random() * (10500-9500) + 9500);
			System.out.println("Vuelvo a casa");
		} catch (InterruptedException e) {
			return;
		}
	}

}
