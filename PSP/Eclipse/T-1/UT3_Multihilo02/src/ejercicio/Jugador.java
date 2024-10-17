package ejercicio;

public class Jugador extends Thread {
	String id;
	Arbitro ar;

	public Jugador(String id, Arbitro ar) {
		super();
		this.id = id;
		this.ar = ar;
	}

	public void run() {
		try {
			while (ar.enJuego()) {
				this.sleep(500);
				if (ar.getTurno() == this.id) {
					int numero = 1 + (int) (10 * Math.random());
					ar.comprobarJugada(id, numero);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
