public class CajeroAutomatico {

	public static void main(String[] args) {
		ProcesoCuenta pc = new ProcesoCuenta();
		Thread one = new Thread(pc);
		Thread two = new Thread(pc);
		one.setName("Juan");
		two.setName("Maria");
		one.start();
		two.start();
	}

}
