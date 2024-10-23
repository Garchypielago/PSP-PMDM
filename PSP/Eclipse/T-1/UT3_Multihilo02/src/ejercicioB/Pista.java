package ejercicioB;

import java.util.ArrayList;

public class Pista {
	
	private int espera = 0;

	public synchronized void zonaPrevia(Aeroplano a) {
		a.espera();

	}

	public synchronized void zonaDespegue(Aeroplano a) {
		try {
			a.pista();
			a.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void despegue(Aeroplano a) {
		try {
			a.sleep(espera);
			espera = a.getTurbulencias() - 2000;
			a.despegue();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
