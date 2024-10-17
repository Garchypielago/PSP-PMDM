package baile;

public class Bailarin {

	private String nombre, casa;
	
	private boolean pareja;

	public Bailarin(String nombre, String casa) {
		super();
		this.nombre = nombre;
		this.casa = casa;
		this.pareja = true;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCasa() {
		return casa;
	}

	public boolean getPareja() {
		return pareja;
	}

	public void setPareja(boolean pareja) {
		this.pareja = pareja;
	}
	
	

}
