package level6;

public class BitCounting {
	
	public static int countBits(int n){
		
		int binar = Integer.bitCount(n); 
		
		return binar;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(countBits(1234));

	}

}
