public class EjecutaMiClaseRunnable {

	public static void main(String[] args) {

		MiClaseRunnable m1 = new MiClaseRunnable("m1");
		Thread t1 = new Thread(m1);
		t1.start();
		MiClaseRunnable m2 = new MiClaseRunnable("m2");
		Thread t2 = new Thread(m2);
		t2.start();
	}
}