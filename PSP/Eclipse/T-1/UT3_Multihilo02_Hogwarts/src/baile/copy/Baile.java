package baile.copy;

import java.util.*;

public class Baile {

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

	public boolean getBailando() {
		return bailando;
	}

	public void enCurso() {
		try {
			Thread tiempo = new Thread();
			tiempo.sleep(minutosBaile * 1000);

			this.bailando = false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.bailando = false;
		}

	}

	public synchronized Bailarin cambioPareja(Bailarina bailarina) {
		Bailarin escogido = bailarina.getPareja();

//		System.out.println("\n");

		Collections.shuffle(bailarines);
		for (Bailarin bailarin : bailarines) {
			if (!(bailarina.getCasa() == "Gryffindor" && escogido.getCasa() == "Slytherin")
					|| !(bailarina.getCasa() == "Slytherin" && escogido.getCasa() == "Gryffindor")
						&& bailarin.getPareja()==false) {
				escogido = bailarin;
				bailarin.setPareja(true);
				
			} else {
				escogido = bailarina.getPareja();
			}
		}

		return escogido;
	}

}
