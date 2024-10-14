package ejemplosClase;

public class contador {

	public int c = 0;
	
	public synchronized void sumar() {
		c++;
	}

}
