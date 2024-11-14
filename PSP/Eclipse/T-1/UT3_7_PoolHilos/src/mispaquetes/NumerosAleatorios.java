package mispaquetes;

import java.util.Random;

public class NumerosAleatorios implements Runnable {

    /**************************************************************************
     * compone una cadena de diez números aleatorios menores que 50, separados
     * por ','
     */
    public void run() {

        String espacio = "";
        Random random = new Random();

        for (int i = 0; i <10; i++) {
            espacio += random.nextInt(50) + ", ";
            Thread.yield();
        }

        System.out.println("Números aleatorio obtenidos por "
                + Thread.currentThread().getName() + ": " + espacio);
    }
}
