package mispaquetes;

public class Principal {

	public static void main(String[] args) {
		// Book object on which wait and notify method will be called
	    Book book=new Book("El Quijote");
	    BookReader JuanLector=new BookReader(book);
	    BookReader RosaLector=new BookReader(book);

	    // BookReader threads which will wait for completion of book
	    Thread Juan=new Thread(JuanLector,"Juan");
	    Thread Rosa=new Thread(RosaLector,"Rosa");

	    Juan.start();
	    Rosa.start();

	    // To ensure both readers started waiting for the book
	    try {
	      Thread.sleep(3000);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    // BookWriter thread which will notify once book get completed
	    BookWriter CervantesEscritor=new BookWriter(book);
	    Thread Cervantes=new Thread(CervantesEscritor);
	    Cervantes.start();		

	}

}
