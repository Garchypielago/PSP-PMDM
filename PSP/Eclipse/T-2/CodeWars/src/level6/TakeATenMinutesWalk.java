package level6;

public class TakeATenMinutesWalk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid(new char[] { 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's' }));

	}

	public static boolean isValid(char[] walk) {
		if (walk.length != 10)
			return false;

		int n1 = 0, n2 = 0;
		for (char d : walk) {
			if ('n' == d)
				n1++;
			if ('w' == d)
				n2++;
			if ('s' == d)
				n1--;
			if ('e' == d)
				n2--;
		}
		return (n1 == 0) && (n2 == 0);
	}
}
