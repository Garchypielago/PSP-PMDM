package baile.copy;

public class Bailarina extends Thread {

	private String nombre, casa;
	
	private Bailarin pareja;

	private Baile finCurso;

	public Bailarina(String nombre, String casa, Bailarin pareja, Baile finCurso) {
		super();
		this.nombre = nombre;
		this.casa = casa;
		this.pareja = pareja;
		this.finCurso = finCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public Bailarin getPareja() {
		return pareja;
	}

	public String getCasa() {
		return casa;
	}

	public void run() {
		try {
			Bailarin auxiliar;
			
		while (finCurso.getBailando()) {
			System.out.println(nombre + " bailará con " + pareja.getNombre());
			
			this.sleep(10000);
			
			auxiliar = this.pareja;
			
			this.pareja = finCurso.cambioPareja(this);
			pareja.setPareja(false);
			
			if (this.pareja != auxiliar) {
			System.out.println(nombre + " cambaiará de pareja");
			} else {
				System.out.println(nombre + " descansará");
			}
		}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
