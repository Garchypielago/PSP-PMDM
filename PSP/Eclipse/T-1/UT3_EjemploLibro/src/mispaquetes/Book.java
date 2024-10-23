package mispaquetes;

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
	public void setCompleted(boolean isCompleted) {
	 this.isCompleted = isCompleted;
	} 
}
