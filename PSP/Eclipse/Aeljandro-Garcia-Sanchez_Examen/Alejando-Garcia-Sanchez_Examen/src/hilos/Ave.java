package hilos;

import java.util.Random;

public class Ave extends Thread {

	private int max, maiz, trigo;
	private String nombre, tipo;
	private Corral corral;

	public Ave(int tipo, String nombre, Corral corral) {
		super();
		if (tipo == 0) {
			this.tipo = "Gallina";
			this.max = 5;
		} else if (tipo == 1) {
			this.tipo = "Gallo";
			this.max = 7;
		}
		this.maiz = 0;
		this.trigo = 0;
		this.nombre = nombre;
		this.corral = corral;
	}

	public int getMaiz() {
		return maiz;
	}

	public void setMaiz(int maiz) {
		this.maiz = maiz;
	}

	public int getTrigo() {
		return trigo;
	}

	public void setTrigo(int trigo) {
		this.trigo = trigo;
	}

	public int getMax() {
		return max;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {
		corral.nuevaAve();
		while (this.max > 0) {
			try {
				System.out.println("La gallina o el gallo " + getNombre() + " empieza a buscar maiz");
				
				if(corral.comer(this)==1) {
					maiz++;
				} else {
					trigo++;
				}
				if(--max>0) {
				sleep(new Random().nextInt(501));
				}
			} catch (InterruptedException e) {
			}
		}
		System.out.println("TOTAL " + getNombre() + " ha comido " + getMaiz() + " dosis de maiz.\n" + "TOTAL "
				+ getNombre() + " ha comido " + getTrigo() + " dosis de trigo.");
		corral.aveFin();
	}

}
