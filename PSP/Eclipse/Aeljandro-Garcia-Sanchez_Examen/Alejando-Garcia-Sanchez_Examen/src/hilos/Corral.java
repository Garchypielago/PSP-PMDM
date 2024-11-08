package hilos;

import java.util.Random;

public class Corral {

	private int[] comedero = { 0, 0, 0 };
	private int maiz, trigo;
	private int ave = 0;

	public int getAve() {
		return ave;
	}

	public synchronized void nuevaAve() {
		this.ave++;
	}

	public synchronized void aveFin() {
		this.ave--;
		notifyAll();
//		imprimirCocina();
	}
	
	public void imprimirFinal() {
		System.out.println("Las aves han parado de comer. PARAMOS EL DISPENSADOR");
		System.out.println("Quedan en los huecos del comedero: [" +comedero[0]+", "+comedero[1]+", "+comedero[2]+"]" );
		int extra=0;
		for (int i: comedero) {
			if (i!=0) {
				extra++;
			}
		}
		System.out.println("Total de dosis que han caído: " + (maiz+trigo+extra));
		System.out.println("Maiz recogido: "+ maiz+", Trigo recogido: "+trigo);
	}

	public synchronized void colocar(int tipo) {
		while ((comedero[0] != 0 && comedero[1] != 0 && comedero[2] != 0) && this.ave > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.ave > 0) {
			if (comedero[0] == 0) {
				comedero[0] = tipo;
			} else if (comedero[1] == 0) {
				comedero[1] = tipo;
			} else if (comedero[2] == 0) {
				comedero[2] = tipo;
			}
			if (tipo == 1) {
				System.out.println("Dispensador ha puesto maiz en el comedero\n [" +comedero[0]+", "+comedero[1]+", "+comedero[2]+"]" );
			} else {
				System.out.println("Dispensador ha puesto trigo en el comedero\n [" +comedero[0]+", "+comedero[1]+", "+comedero[2]+"]" );
			}
		}
		notifyAll();
	}

	public synchronized int comer(Ave ave) {
		while (!(comedero[0] != 0 || comedero[1] != 0 || comedero[2] != 0)) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int tipo = 0;

		try {
			
			for (int i = 1; i <= 2; i++) {
				if (comedero[0] == i) {
					tipo = i;
					ave.sleep(new Random().nextInt(201));
					comedero[0]=0;
					break;
				} else if (comedero[1] == i) {
					tipo = i;
					ave.sleep(new Random().nextInt(201));
					comedero[1]=0;
					break;
				} else if (comedero[2] == i) {
					tipo = i;
					ave.sleep(new Random().nextInt(201));
					comedero[2]=0;
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(tipo==1) {
			System.out.println("La gallina o el gallo " + ave.getNombre()+ " ya HA ACABADO de comer maiz");
			maiz++;
		} else {
			System.out.println("La gallina o el gallo " + ave.getNombre()+ " ya HA ACABADO de comer trigo");
			trigo++;
		}
		notifyAll();
		return tipo;

	}

}
