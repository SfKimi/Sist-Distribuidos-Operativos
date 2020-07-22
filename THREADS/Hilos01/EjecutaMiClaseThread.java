
public class EjecutaMiClaseThread {

	public static void main(String[] args) {

		MiClaseThread m1 = new MiClaseThread("m1");
		m1.start();
		MiClaseThread m2 = new MiClaseThread("m2");
		m2.start();
	}
}