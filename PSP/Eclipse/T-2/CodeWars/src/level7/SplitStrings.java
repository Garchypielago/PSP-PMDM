package level7;

import java.util.ArrayList;

public class SplitStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String word : solution("LovePizza"))
			System.out.println(word);
	}

	public static String[] solution(String s) {
		// Write your code here
		if(s.length()==0) {
			return new String[0];
		}
		ArrayList<String> word = new ArrayList<>();
		String aux = "";
		int cont = 0;

		for (String st : s.split("")) {
			if (cont % 2 == 0) {
				aux += st;
				word.add(aux+"_");
			} else {
				word.set(word.size() - 1, aux+st);
				aux = "";
			}
			cont++;
		}
		if (word.get(word.size() - 1).length() == 1) { 
			word.set(word.size() - 1, aux+"_");
		}
		
		String[] solution = word.toArray(new String[0]);

		return solution;
	}

}
