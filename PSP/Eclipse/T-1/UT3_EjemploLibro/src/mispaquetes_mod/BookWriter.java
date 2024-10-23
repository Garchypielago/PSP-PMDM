package mispaquetes_mod;

//This class will notify thread(in case of notify) which is waiting on book object. 
//It will not give away lock as soon as notify is called, it first complete its synchronized block. 
//So in this example, BookWriter will complete the book and notify it to BookReaders. 
public class BookWriter implements Runnable{
	Book book;
	
	public BookWriter(Book book) {
	 super();
	 this.book = book;
	}
	
	@Override
	public void run() {	   
	   book.escribirLibro(book.getTitle());

	}
}
