package ejemplosClase;

public class contadorHilos extends Thread{
	
	contador c;
	
	public contadorHilos(contador c) {
		super();
		this.c = c;
	}

	public void run() {
		for (int i=0 ; i<2500; i++) {
			c.sumar();
		}
		System.out.println(c.c);
	}
}
