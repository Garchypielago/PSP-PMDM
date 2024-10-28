package hilos;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Controlador {

	private String path;
	private Double saldo;
	private boolean terminado;
	private Scanner sc;
	private int hilos;
	private List<String> internas, externas, sinSaldo;

	public Controlador(File fichero, Double saldo, String path) {
		super();
		this.path = path;
		this.terminado = false;
		this.saldo = saldo;
		this.hilos = 0;
		this.internas = new ArrayList<String>();
		this.externas = new ArrayList<String>();
		this.sinSaldo = new ArrayList<String>();
		try {
			this.sc = new Scanner(fichero);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean getTerminado() {
		return terminado;
	}

	public synchronized Double getSaldo() {
		return saldo;
	}

	public synchronized Double restarSaldo(Double sueldo) {
		return this.saldo -= sueldo;
	}

	public synchronized void nuevoHilo() {
		this.hilos++;
	}
	
	public synchronized void agregarTrans(int i, String trans) {
		switch (i){
		case 0:
			this.sinSaldo.add(trans);
			break;
		case 1:
			this.internas.add(trans);
			break;
		case 2:
			this.externas.add(trans);
			break;
		}
	}

	
//	controlador de impresion , no era necesario pero ya l dejo
	public synchronized void hiloTerminado(Hilo h) {
		this.hilos--;
		boolean finalProg = false;
		if (this.hilos == 1) {
			finalProg = true;
		}
			
		if (this.hilos > 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			notifyAll();
		}
		
		System.out.println(
				"Este hilo: " + h.getNombre() + " ha realizado transferencias por valor de: " + h.getSuma() + "€.");

		if (finalProg) {
			try {
				Files.write(Paths.get(path + "transferenciasInt.txt"), internas);
				Files.write(Paths.get(path + "transferenciasExt.txt"), externas);
				Files.write(Paths.get(path + "transferenciasSinSaldo.txt"), sinSaldo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Quedan " + getSaldo() + "€ en la cuenta.");
			System.out.println("Fin de porgrama.");
		}
	}

	public synchronized String transaccionar() {
//		hago este por is acadso, conrtrolo la salida del null en el hilo
		if (this.sc.hasNextLine()) {

			String transaccion;
			transaccion = this.sc.nextLine();

			if (!this.sc.hasNextLine()) {
				this.terminado = true;
				this.sc.close();
			}

			return transaccion;
		}
		return null;
	}
}
