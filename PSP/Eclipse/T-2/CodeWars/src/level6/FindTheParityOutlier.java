package level6;

public class FindTheParityOutlier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	static int find(int[] integers) {
		boolean par = par(integers[0],integers[1],integers[2]);
		int numero;
		
		for (int num : integers) {
			if(par) {
				if(num%2==0)
					return num;
			} else {
				if(num%2!=0)
					return num;
			}
		}
		return 0;
	  }
	
	private static boolean par(int i, int j, int k) {
		if(i%2==0 && j%2==0 || i%2==0 && k%2==0 ||j%2==0 && k%2==0) 
			return false;
		return true;
	}

}
