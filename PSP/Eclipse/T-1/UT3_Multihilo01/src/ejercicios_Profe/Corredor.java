package ejercicios_Profe;

public class Corredor extends Thread{

	
	
	private String corredor;
	private CorrerRelevoEquipo miEquipoRelevo;
	
	public Corredor(String corredor, CorrerRelevoEquipo miEquipoRelevo ) {
	
		super ();		
		this.corredor = corredor;
		this.miEquipoRelevo = miEquipoRelevo;
		}


	
	@Override
	public void run() {
		
		this.miEquipoRelevo.carrera(corredor);		
	}
}
