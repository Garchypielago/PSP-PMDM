package ejercicioB;

public enum Tipo {
	
	AVION("avión", 3000), AVIONETA("avioneta", 2000);
	
	String tipo;
	int turbulencias;
	
	Tipo(String tipo, int turbulencias) {
		this.tipo = tipo;
		this.turbulencias = turbulencias;
	}
	
}
