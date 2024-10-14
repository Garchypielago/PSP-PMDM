package ejemplosClase;

public class contadorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		contador c = new contador();		
		contadorHilos h1 = new contadorHilos(c);
		contadorHilos h2 = new contadorHilos(c);
		contadorHilos h3 = new contadorHilos(c);
		contadorHilos h4 = new contadorHilos(c);
		contadorHilos h5 = new contadorHilos(c);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();
		
//		System.out.println(c.c);

	}

}
