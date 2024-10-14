package mispquetes;

class Contador3 {
	private int c = 0;
	Contador3(int c) {
		this.c = c;
	}

	public synchronized void incrementa() {
		c = c + 1;
	}

	public synchronized void decrementa() {
		c = c - 1;
	}

	public synchronized int getValor() {
		return c;
	}

}// CONTADOR

class HiloA3 extends Thread {
	private Contador3 contador;
	public HiloA3(String n, Contador3 c) {
		setName(n);
		contador = c;
	}
	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.incrementa();
			/*
			 * try { sleep(100); } catch (InterruptedException e) { }
			 */
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOA

class HiloB3 extends Thread {
	private Contador3 contador;
	public HiloB3(String n, Contador3 c) {
		setName(n);
		contador = c;
	}
	public void run() {
		for (int j = 0; j < 300; j++) {
			contador.decrementa();
			/*
			 * try { sleep(100); } catch (InterruptedException e) {}
			 */
		}
		System.out.println(getName() + " contador vale " + contador.getValor());
	}
}// FIN HILOB

public class Compartir03 {
	public static void main(String[] args) {
		Contador3 cont = new Contador3(100);
		HiloA3 a = new HiloA3("HiloA", cont);
		HiloB3 b = new HiloB3("HiloB", cont);
		a.start();
		b.start();       
	}
}