package level7;

public class GetTheMiddleCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String getMiddle(String word) {
	    //Code goes here!
	    String[] arr = word.split("");

	    if (arr.length%2==0){
	      word = arr[arr.length/2]+arr[arr.length/2 + 1];
	    } else {
	       word = arr[arr.length/2];
	    }
	    
	    return word;
	  }

}
