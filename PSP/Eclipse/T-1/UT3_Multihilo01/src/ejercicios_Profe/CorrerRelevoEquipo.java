package ejercicios_Profe;

public class CorrerRelevoEquipo {
	
	private String equipo;
	
	public CorrerRelevoEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	public synchronized void carrera(String corredor) {	
		try {
			Integer numero = (int)(Math.random()*(1050-950+1)+950);
			System.out.printf(equipo+ ":"+corredor+" comienza su relevo%n") ;
			for (int i=0; i<10; i++) {
				Thread.sleep(numero);
			}
			Float tiempo = numero.floatValue()/100;
			System.out.printf(equipo+ ":"+corredor+" ha acabado su relevo - "+
			"Ha tardado: "+ tiempo +" segundos%n") ;
		}catch (InterruptedException e) {
			e.printStackTrace () ;
		}					
	}	
}
