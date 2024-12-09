package level7;

import java.lang.reflect.Array;
import java.util.TreeSet;

public class HighestAndLowest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String numbers = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";

	    String[] numsString = numbers.split(" ");
	    TreeSet numsInt = new TreeSet();
	    
	    for (String num : numsString){
	      numsInt.add(Integer.parseInt(num));
	    }
	    
	    String result = numsInt.first()+" "+numsInt.last();
	    
	    System.out.println(result);

	}

}
