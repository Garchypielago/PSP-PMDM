package mispaquetes_mod;

//It is the common java class on which thread will act and call wait and notify method.
public class Book {
	String title;
	boolean isCompleted;
	
	public Book(String title) {
	 super();
	 this.title = title;
	}
	public String getTitle() {
	 return title;
	}
	public void setTitle(String title) {
	 this.title = title;
	}
	public boolean isCompleted() {
	 return isCompleted;
	}
	
	public synchronized void leerLibro(String name) {
		if(!this.isCompleted) {
			try {
				System.out.println(name+" estoy esperando que completen el libro");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+": Book has been completed now!! you can read it");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void escribirLibro(String name) {
		  System.out.println("Author is Starting book : " +name );
		   try {
		     Thread.sleep(5000);
		   } catch (InterruptedException e) {
		     e.printStackTrace();
		   }
		   this.setCompleted(true);
		   System.out.println("Book has been completed now");

	}
	
	public synchronized void setCompleted(boolean isCompleted) {
		 this.isCompleted = isCompleted;
		 this.notify();
		 System.out.println("notify one reader");
		   
		 //this.notifyAll();
		 //System.out.println("notifyreaders");
	} 
}
