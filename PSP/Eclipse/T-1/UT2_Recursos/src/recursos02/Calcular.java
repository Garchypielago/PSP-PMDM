package recursos02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calcular {
	public static void main(String[] args) throws IOException, InterruptedException 
	{        
		
		/*
		 * InputStreamReader in = new InputStreamReader(System.in); 
		 * BufferedReader br = new BufferedReader (in);
		 */
		Scanner sc = new Scanner(System.in);
		Integer numero;
		
		try {	
						
			//numero = Integer.parseInt(br.readLine());
			numero = sc.nextInt();
			if (numero % 2 == 0) {
				System.out.println("El número es par" );
		    } else {
		    	System.out.println("El número es impar" );
		    	System.out.println("El número es impar REPITO" );
		    }			
	        System.exit(0);
			}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);			
			}		
	}	
}
