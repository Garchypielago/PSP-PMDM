package repartoComida;

import java.util.Random;

public class Repartidor extends Thread {

	private int comida, repartos;
	private Horno res;
	private int hamburguesas, pizzas;

	public Repartidor(int pref, Horno res) {
		super();
		this.comida = pref;
		this.res = res;
		this.repartos = 15;
		this.hamburguesas = 0;
		this.pizzas = 0;
	}

	public int getComida() {
		return comida;
	}

	@Override
	public void run() {
		res.nuevoRepartidor();
		int reparte = 0;

		try {
			for (; repartos > 0; repartos--) {
				reparte = res.repartir(comida);
				if (reparte == 1) {
					hamburguesas++;
				} else if (reparte == 2) {
					pizzas++;
				}
				sleep(new Random().nextInt(600));
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		res.finTurnoRepartidor();
		
		System.out.println("-----------------------------------------\n"
				+ "El repartidor " + this.getName() + " ha repartido " + hamburguesas + " hamburguesas\n"
				+ "El repartidor " + this.getName() + " ha repartido " + pizzas + " pizzas\n"
				+ "-----------------------------------------\n");

	}

}