package aeropuerto;

public class Aeroplano extends Thread{
	
	private Tipo tipo;
	
	private String nombre;
	private int turbulencias;
	
	private Pista pista;

	public Aeroplano(int aleatorio, String nombre, Pista pista) {
		super();
		this.nombre = nombre;
		if (aleatorio%2==0) {
			this.tipo = Tipo.AVION;
			this.turbulencias = tipo.turbulencias;
			this.setPriority(MAX_PRIORITY);
		} else {
			this.tipo = Tipo.AVIONETA;
			this.turbulencias = tipo.turbulencias;
			this.setPriority(MIN_PRIORITY);
		}
		this.pista = pista;
	}
	
	
	public int getTurbulencias() {
		return turbulencias;
	}


	public void run() {
		pista.zonaPrevia(this);
		pista.zonaDespegue(this);
		pista.despegue(this);
	}
	
	public void espera() {
		System.out.println("Llega a pista " + nombre + "(" + tipo.tipo + ")");
	}
	
	public void pista() {
			System.out.println("Se prepara para despegar " + nombre + "(" + tipo.tipo + ")");
	}
	
	public void despegue() {
		System.out.println("Despega " + nombre + "(" + tipo.tipo + "), esperaremos " + (turbulencias/1000) + "min.");
	}

}
