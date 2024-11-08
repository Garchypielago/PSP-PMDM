package repartoComida;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horno res = new Horno();
		
		Repartidor Pepe = new Repartidor(0, res);
		Repartidor Maria = new Repartidor(0, res);
//		Repartidor Yeye = new Repartidor(0, res);
		Repartidor Paolo = new Repartidor(1, res);
		Repartidor Raquel = new Repartidor(2, res);
		
		Cocinero Juan = new Cocinero(1, res);
		Cocinero Giolo = new Cocinero(2, res);
		
//		Yeye.start();
		Paolo.start();
		Raquel.start();
		Pepe.start();
		Maria.start();
		Juan.start();
		Giolo.start();

	}

}
