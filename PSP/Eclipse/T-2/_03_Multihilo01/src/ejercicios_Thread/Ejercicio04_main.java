package ejercicios_Thread;

public class Ejercicio04_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejercicio04_equipos españa = new Ejercicio04_equipos("ESPAÑA");
		Ejercicio04_equipos eeuu = new Ejercicio04_equipos("EEUU");
		
		españa.add("Pepe");
		españa.add("Maria");
		españa.add("Juan");
		eeuu.add("John");
		eeuu.add("Kim");
		eeuu.add("Mike");
		
		españa.start();
		eeuu.start();
		

	}

}
