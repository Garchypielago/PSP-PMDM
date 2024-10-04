package ejercicios;

import java.io.*;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		System.out.println("Escribe el nombre de la asignatura:");
		String nom_asig=sc.nextLine();
//		System.out.println("Escribe el nombre del fichero:");
		String nom_fich=sc.nextLine();
		
		int contador = 0, aprobados = 0;
		double media = 0, num;
		
		File fentrada = new File("E:\\Escritorio\\Git_REPOSITORIOS\\Curso02\\PSP-PMDM\\PSP\\Eclipse\\T-2\\Ej3_Multiprocesos_Padres\\TXT\\ej04\\"+nom_fich);
		
		try (BufferedReader br = new BufferedReader(new FileReader(fentrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                num = Double.parseDouble(linea);
                if (num>=5)
                	aprobados++;
                media += num;
                contador++;
            }
            
            System.out.println("En la asignatura " + nom_asig +
            					"\nHan aprobado: " + aprobados +
            					"\nLa media es: " + media/contador);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.exit(-1);
		
		
		
	}

}
