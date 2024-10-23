package baile;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bailarin HarryPotter = new Bailarin("HarryPotter", "Gryffindor");
		Bailarin DracoMalfoy = new Bailarin("DracoMalfoy", "Slytherin");
		Bailarin CedricDigory = new Bailarin("CedricDigory", "Hufflepuff");
		Bailarin TerryBoot = new Bailarin("TerryBoot", "Ravenclaw");
		
		ArrayList<Bailarin> bailarines = new ArrayList<>();
        bailarines.add(HarryPotter);
        bailarines.add(DracoMalfoy);
        bailarines.add(CedricDigory);
        bailarines.add(TerryBoot);
		
		Baile finCurso = new Baile(bailarines);
		
		Bailarina HermioneGranger = new Bailarina("Hermione Granger", "Gryffindor", HarryPotter, finCurso);
		Bailarina PansyParkinson = new Bailarina("Pansy Parkinson", "Slytherin", DracoMalfoy, finCurso);
		Bailarina TamsinApplebee = new Bailarina("Tamsin Applebee", "Hufflepuff", CedricDigory, finCurso);
		Bailarina LunaLovewood = new Bailarina("Luna Lovewood", "Ravenclaw", TerryBoot, finCurso);
		
//		finCurso.enCurso(); no funciona revisalo
		HermioneGranger.start();
		PansyParkinson.start();
		TamsinApplebee.start();
		LunaLovewood.start();
		
		

	}

}
