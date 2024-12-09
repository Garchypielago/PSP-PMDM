package level7;

public class SumOfOddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        int result = rowSumOddNumbers(42);
	      System.out.println(result);
	}
	
	public static int rowSumOddNumbers(int n) {
	      //TODO
	      int result = calc(n);
	      int aux = result;
	      
	      for (int i=1; i<n; i++){
	        aux+=2;
	        result += aux;
	      }
	      
	      return result;
	    }
	
	public static int calc(int n) {
	      if(n==1)
	        return 1;
	      
	      int result = calc(n-1)+2*(n-1);
	      
	      return result;
	    }
		
	}


