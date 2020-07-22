package co.edu.usbbog.so.procesos;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author MundoChocCacA
 */
public class RoundRobin {

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		// TODO code application logic here

		int guantum = 5;
		int contador = 0;

		TreeMap<Integer, Integer> agenda = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> rrtemp = new TreeMap<Integer, Integer>();

		agenda.put(1, 53);
		agenda.put(2, 20);
		agenda.put(3, 15);
		agenda.put(4, 10);
		agenda.put(5, 53);

		System.out.println("Procesos con ms" + agenda);
		System.out.println("No. procesos activos " + agenda.size());

		while (agenda.isEmpty() != true) {

			for (int xx = 1; xx <= agenda.size(); xx++) {
				int menosqua = 0;

				contador = guantum;

				// System.out.println("Mapa="+agenda);
				// System.out.println("xx="+xx);
				menosqua = agenda.get(xx);
				while (contador != 0) {
					/*
					 * menosqua--; contador--;
					 */
					if (menosqua != 0 && menosqua >= 0) {

						agenda.put(xx, menosqua);
						System.out.println("->No. proceso " + xx + " iniciado " + agenda.get(xx) + " ms");
						try {
							Thread.sleep(agenda.get(xx) * 10);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}

					} else {
						if (menosqua == 0) {
							System.out.println("=======>No. proceso " + xx + " terminado " + agenda.get(xx) + " ms");
							agenda.remove(xx);
							/*
							 * si el proceso termino se elimina y se junta los
							 * procesos para *
							 */

							// System.out.println("->>>>>>>>>>>>"+agenda);
							int sumador = 0;

							for (Map.Entry entry : agenda.entrySet()) {
								sumador++;
								// System.out.println("llave = " +
								// entry.getKey() + ", valor = " +
								// entry.getValue());
								int entrada = Integer.parseInt(entry.getValue().toString());
								rrtemp.put(sumador, entrada);
							}
							/*
							 * for(int quitar=0;quitar<agenda.size();quitar++) {
							 * agenda.remove(quitar); }
							 */
							agenda.clear();
							// System.out.println("Vacio->>>>><<<<<<<<<<>>>"+agenda);

							for (int xdf = 1; xdf <= rrtemp.size(); xdf++) {
								agenda.put(xdf, rrtemp.get(xdf));
							}

							rrtemp.clear();
							// System.out.println("LLeno->>>>><<<<<<<<<<>>>"+agenda);

						}
					}
					menosqua--;
					contador--;
				}
			}
		}
		System.out.println("Tiempo " + agenda + " ms.");
		System.out.println("No. procesos " + agenda.size());

	}
}