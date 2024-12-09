package level7;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(twoSum(new int[]{1,2,3}, 4));

	}
	
	public static int[] twoSum(int[] numbers, int target) {
        // Do your magic!
		for (int i = 0; i < numbers.length; i++) {
	        for (int j = i + 1; j < numbers.length; j++) {
	            if (numbers[i] + numbers[j] == target) {
	                return new int[]{i, j}; 
	            }
	        }
	    }
	    return null;
	}
}
