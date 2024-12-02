package ej02;

import java.io.Serializable;

public class Jugada02 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int cliente, servidor;
	private boolean clientePar;
	private String ganador;

	public Jugada02(int cliente, boolean clientePar) {
		super();
		this.cliente = cliente;
		this.clientePar = clientePar;
	}
	
	
	public int getCliente() {
		return cliente;
	}


	public int getServidor() {
		return servidor;
	}


	public boolean isClientePar() {
		return clientePar;
	}


	public String getGanador() {
		return ganador;
	}


	public void jugadaServidor(int servidor) {
		this.servidor=servidor;
		ganador();
	}

	public void ganador() {
		int resultado = (servidor+cliente)%2;
		
		if ( (clientePar && resultado==0) || (!clientePar && resultado!=0) ) {
			ganador = "Cliente";
		} else {
			ganador = "Servidor";
		}
	}

}
