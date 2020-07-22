public class SubirBajar extends Thread {

	private String palabra;

	public SubirBajar(String str) {
		palabra = str;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(palabra);
		}

	}

}
