package repartoComida;

import java.util.Random;

public class Cocinero extends Thread {

	private int comida;
	private Horno res;

	public Cocinero(int i, Horno res) {
		super();
		this.comida = i;
		this.res = res;
	}

	public String tipoComida() {
		if (comida == 1) {
			return "hamburguesa";
		} else if (comida == 2) {
			return "pizza";
		}
		return null;
	}

	public int tiempoComida() {
		if (comida == 1) {
			return 200;
		} else if (comida == 2) {
			return 300;
		}
		return 0;
	}

	@Override
	public void run() {
		try {
			while (res.repartidoresDisponibles() > 0) {
				System.out.println("Cocinando: " + tipoComida());
				sleep(new Random().nextInt(tiempoComida()));
				res.colocar(comida);
				
			}
		} catch (InterruptedException e) {
		}
		if (comida == 1) {
			System.out.println("-----------------------------------------\n"
					+ "Se PARA la cocina de hamburguesas.\n"
					+ "-----------------------------------------");

		} else if (comida == 2) {
			System.out.println("-----------------------------------------\n"
					+ "Se PARA la cocina de pizzas.\n"
					+ "-----------------------------------------");
		}
		

	}

}
