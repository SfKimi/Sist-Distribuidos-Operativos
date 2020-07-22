public class PeligroCuenta implements Runnable {
	private CuentaBanco cb = new CuentaBanco();

	public void run() {
		for (int x = 0; x < 5; x++) {
			realizarRetiro(10);
			if (cb.getSaldo() < 0) {
				System.out.println("Cuenta sobregirada - Saldo actual: " + cb.getSaldo());
			}
		}
	}

	private void  realizarRetiro(int valor) {
		if (cb.getSaldo() >= valor) {
			System.out.println(Thread.currentThread().getName() + " Se prepara para retirar: " + valor
					+ " y el saldo en este momento es de : " + cb.getSaldo());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}
			cb.retiro(valor);
			System.out.println(
					Thread.currentThread().getName() + " realizó el retiro de: " + valor + "\n - Resultado existoso");
		} else {
			System.out.println("No hay saldo suficiente para " + Thread.currentThread().getName()
					+ " para poder retirar " + cb.getSaldo());
		}
	}

}
