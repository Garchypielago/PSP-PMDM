package level7;

import java.util.ArrayList;
import java.util.List;

public class FriendOrFoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(friend(List.of("Ryan", "Kieran", "Jason", "Yous")));

	}
	public static List<String> friend(List<String> x){
	     // Your code here
		x = new ArrayList<>(x);
		x.removeIf(n -> (n.length() != 4));
		
	     return x;
	   }

}
