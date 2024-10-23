package mispaquetes;

//It will first take a lock on book object 
//Then, the thread will wait until other thread call notify method, then after it will complete its processing. 
//So in this example, it will wait for BookWriter to complete the book.
public class BookReader implements Runnable{
	Book book;
	
	public BookReader(Book book) {
	 super();
	 this.book = book;
	}
	
	@Override
	public void run() {
	 synchronized (book) {
		 System.out.println(Thread.currentThread().getName()+" is waiting for the book to be completed: "+book.getTitle());
//		 while(!book.isCompleted){
		 if(!book.isCompleted){
		   try {
			     book.wait();
			   } catch (InterruptedException e) {  
			     e.printStackTrace();
			   } 
		 }	
		 try {
		     Thread.sleep(2000);
		   } catch (InterruptedException e) {
		     e.printStackTrace();
		   }
	   System.out.println(Thread.currentThread().getName()+": Book has been completed now!! you can read it");
	 }
	} 
}
