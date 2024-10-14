package ejercicios_Profe;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorrerRelevoEquipo miRelevoEspaña = new CorrerRelevoEquipo("España");
		CorrerRelevoEquipo miRelevoEEUU = new CorrerRelevoEquipo("EEUU");
		Corredor hiloEsp[] = new Corredor[4];
		Corredor hiloEEUU[] = new Corredor[4];
		
		String Equipo[]= {"Pepe","Maria","Juan","Marta"};
		String Equipo2[]= {"John","Kate","Larry","Sarah"};
		
		 //Creamos objetos en cada posicion       		
		for(int i=0; i<Equipo.length;i++ ) {
			hiloEsp[i] =  new Corredor(Equipo[i],miRelevoEspaña);
			hiloEsp[i].start();
			hiloEEUU[i] =  new Corredor(Equipo2[i],miRelevoEEUU);
			hiloEEUU[i].start();
//			try {
//				hilo[i].join();
//			   } catch (InterruptedException e) { }
		}		
		
		System.out.println("FINAL DE PROGRAMA");	   
	}

}
