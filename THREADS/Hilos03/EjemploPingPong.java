public class EjemploPingPong extends Thread {

	private String palabra; // variable a imprimir
	private int tiempoDeEspera; // tiempo entre impresiones

	public EjemploPingPong(String queImprimir, int cantidadSegundos) {
		palabra = queImprimir;
		tiempoDeEspera = cantidadSegundos;
	}

	public void run() { // sobreescritura del método
		while (true) {
			System.out.println(palabra + "");
			try {
				sleep(tiempoDeEspera);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
