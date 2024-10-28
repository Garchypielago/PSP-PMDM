package hilos;

public class Hilo extends Thread {

	private String nombre;
	private Double suma;
	private Controlador syn;

	public Hilo(String nombre, Controlador syn) {
		super();
		this.nombre = nombre;
		this.suma = 0.0;
		this.syn = syn;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getSuma() {
		return suma;
	}

	@Override
	public void run() {
		String CuentaSueldo, cuenta;
		double sueldo;
		syn.nuevoHilo();

		while (!syn.getTerminado()) {
			CuentaSueldo = syn.transaccionar();
			cuenta = CuentaSueldo.split(";")[0];
			sueldo = Double.parseDouble(CuentaSueldo.split(";")[1]);

			if ((syn.getSaldo() - sueldo) >= 0) {

				if (cuenta.split("")[0].equalsIgnoreCase("1")) {
//				trasnferencia interna
					try {
						System.out.println("Cuenta: " + cuenta + " - Actualizamos saldo de la cuenta con el importe: "
								+ sueldo + "€.\n" + "\tGrabamos transferencia INTERNA. Cuenta: " + cuenta + "\n"
								+ "\tSaldo restante: " + syn.restarSaldo(sueldo) + "€.");
						syn.agregarTrans(1, CuentaSueldo);
						this.sleep(1000);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (cuenta.split("")[0].equalsIgnoreCase("2")) {
//				transferencia externa

					System.out.println("Cuenta: " + cuenta + " - Actualizamos saldo de la cuenta con el importe: "
							+ sueldo + "€.\n" + "\tGrabamos transferencia EXTERNA. Cuenta: " + cuenta + "\n"
							+ "\tSaldo restante: " + syn.restarSaldo(sueldo) + "€.");
					syn.agregarTrans(2, CuentaSueldo);

				} else {
//				controlar posible error, por si acaso
					System.out.println("Error de ejecucion en: " + nombre);
				}
			} else {
				System.out.println("No hay saldo para la siguiente transferencia de: " + sueldo + "€.");
				syn.agregarTrans(0, CuentaSueldo);
			}
			this.suma += sueldo;
		}
		syn.hiloTerminado(this);

	}

}
