
public class MiClaseThread extends Thread {

	private String descripcion;

	public MiClaseThread(String str) {

		descripcion = str;

	}

	@Override
	public void run() {

		for (int i = 0; i < 10; i++)
			System.out
					.println(descripcion + ": Este es el Thread " + getName());

	}
}