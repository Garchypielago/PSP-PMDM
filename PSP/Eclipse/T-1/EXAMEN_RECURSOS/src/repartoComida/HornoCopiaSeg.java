package repartoComida;

public class HornoCopiaSeg {

	private int pizzas = 0;
	private int hamburguesas = 0;
	private int repartidor = 0;

	public synchronized int repartidoresDisponibles() {
		notifyAll();
		return repartidor;
	}

	public synchronized  void nuevoRepartidor() {
		this.repartidor++;
	}

	public synchronized  void finTurnoRepartidor() {
		this.repartidor--;
		notifyAll();
	}
	
	public synchronized int huecoHorno(int tipo) {
		if (tipo == 1) {
			return 3 - hamburguesas;
		} else if (tipo == 2) {
			return 2 - pizzas;
		}
		return 0;
	}
	
//	public synchronized void terminar() {
//		notifyAll();
//	}

	public synchronized void colocar(int tipo) {
		if (tipo == 1) {
			while (hamburguesas >= 3 || this.repartidoresDisponibles() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			if (this.repartidoresDisponibles() > 0) {
				hamburguesas++;
				System.out.println("Hamburguesa lista, hay: " + hamburguesas);
				notifyAll();
//			}
//			if (huecoHorno(1) == 0) {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}
		if (tipo == 2) {
			while (pizzas >= 2 || this.repartidoresDisponibles() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
//			if (this.repartidoresDisponibles() > 0) {
				pizzas++;
				System.out.println("Pizza lista, hay: " + pizzas);
				notifyAll();
//			}
//			if (huecoHorno(2) == 0) {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
		}

	}

//	public synchronized void colocarHamburguesa() {
//		while (hamburguesas >= 3) {
//			try {
//				wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		if (this.repartidoresDisponibles() > 0) {
//			hamburguesas++;
//			System.out.println("Hamburguesa lista hay: " + hamburguesas);
//			notifyAll();
//		}
//	}

	public synchronized int repartir(int preferencia) {
		if (preferencia == 0) {
			while (hamburguesas <= 0 || pizzas <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (hamburguesas > 0) {
				hamburguesas--;
				System.out.println("\tReparto hamburguesa, hay: " + hamburguesas);
				notifyAll();
				return 1;
			} else if (pizzas > 0) {
				pizzas--;
				System.out.println("\tReparto pizza, hay: " + pizzas);
				notifyAll();
				return 2;
			}
		}
		if (preferencia == 1) {
			while (hamburguesas <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hamburguesas--;
			System.out.println("\tReparto hamburguesa, hay: " + hamburguesas);
			notifyAll();
			return 1;
		}
		if (preferencia == 2) {
			while (pizzas <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			pizzas--;
			System.out.println("\tReparto pizza, hay: " + pizzas);
			notifyAll();
			return 2;
		}
		
		return 0;

	}

}
