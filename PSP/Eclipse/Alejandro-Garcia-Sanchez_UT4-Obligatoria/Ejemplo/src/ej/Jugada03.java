package ej;

import java.io.Serializable;

public class Jugada03 implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cliente01, cliente02;
	private boolean clientePar, turno;
	private String ganador;

	public Jugada03() {
		super();
		this.turno = true;
	}
	
	public void reset() {
		this.turno = true;
	}

	public boolean getTurno() {
		return turno;
	}

	public void changeTurno() {
		this.turno = !this.turno;
	}

	public int getCliente01() {
		return cliente01;
	}

	public int getCliente02() {
		return cliente02;
	}

	public boolean isCliente01Par() {
		return clientePar;
	}

	public String getGanador() {
		return ganador;
	}

	public synchronized void jugadaCliente(int cliente, boolean par) {
		if (turno) {
			this.cliente01 = cliente;
			this.clientePar = par;
		} else {
			this.cliente02 = cliente;
		}
	}
	
	public void mergeJugada(Jugada03 jugadaC02) {
		this.cliente02 = jugadaC02.getCliente02();
	}

	public void ganador() {
		int resultado = (cliente02 + cliente01) % 2;

		if ((clientePar && resultado == 0) || (!clientePar && resultado != 0)) {
			if (turno) {
				ganador = "Gano";
			} else {
				ganador = "Pierdo";
			}
		} else {
			if (!turno) {
				ganador = "Gano";
			} else {
				ganador = "Pierdo";
			}
		}
	}

}
