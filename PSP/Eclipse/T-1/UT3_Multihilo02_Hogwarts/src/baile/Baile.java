package baile;

import java.util.*;

public class Baile{

	private int minutosBaile;

	private boolean bailando;

	private ArrayList<Bailarin> bailarines;
	
	private int contador;

	public Baile(int minutosBaile, ArrayList<Bailarin> bailarines) {
		super();
		this.minutosBaile = minutosBaile;
		this.bailando = true;
		this.bailarines = bailarines;
		this.contador = 0;
	}

	public Baile(ArrayList<Bailarin> bailarines) {
		super();
		this.minutosBaile = 2;
		this.bailando = true;
		this.bailarines = bailarines;
		this.contador = 0;
	}

	public synchronized boolean getBailando() {
		return bailando;
	}

	public void enCurso() {
		try {
			Thread tiempo = new Thread();
			tiempo.sleep(minutosBaile * 10000);

			this.bailando = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.bailando = false;
		}

	}

	
	public synchronized void liberarPareja(Bailarina bailarina) {
		if (bailarina.getPareja()!=null) {
		bailarines.get(bailarines.indexOf(bailarina.getPareja())).setPareja(false);
		}
		return;
	}
	
	public synchronized Bailarin cambioPareja(Bailarina bailarina) {
        Bailarin escogido = bailarina.getPareja(); // Obtener la pareja actual

        // Mezclar la lista de bailarines
        ArrayList<Bailarin> bailarinesCopy = (ArrayList<Bailarin>) bailarines.clone();
        Collections.shuffle(bailarinesCopy);

        for (Bailarin bailarin: bailarinesCopy) {
            // Condición para verificar las casas y si el bailarin no tiene pareja
            if (!((bailarina.getCasa().equals("Gryffindor") && bailarin.getCasa().equals("Slytherin"))
                    || (bailarina.getCasa().equals("Slytherin") && bailarin.getCasa().equals("Gryffindor")))
                    && bailarin.getPareja()==false && escogido != bailarin) {

                escogido = bailarin; // Cambiar la pareja
//                bailarin.setPareja(true);
                break; // Salir del bucle después de encontrar un bailarin adecuado
            }
        }

        if (escogido!=null) {
        bailarines.get(bailarines.indexOf(escogido)).setPareja(true);
        }

        return escogido; // Retornar el bailarín seleccionado
    }

}
