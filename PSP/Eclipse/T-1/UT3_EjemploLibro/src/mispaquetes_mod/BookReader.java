package mispaquetes_mod;

//It will first take a lock on book object 
//Then, the thread will wait until other thread call notify method, then after it will complete its processing. 
//So in this example, it will wait for BookWriter to complete the book.
public class BookReader implements Runnable{
	Book book;
	String nombre;
	
	public BookReader(Book book,String nombre) {
	 super();
	 this.book = book;
	 this.nombre = nombre;
	}
	
	@Override
	public void run() {
		book.leerLibro(this.nombre);
	} 
}
