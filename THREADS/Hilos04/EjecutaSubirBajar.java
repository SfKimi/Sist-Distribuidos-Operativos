public class EjecutaSubirBajar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread tM = new SubirBajar("HOLA");
		Thread tm = new SubirBajar("hola");
		tm.setPriority(Thread.MAX_PRIORITY);
		tM.setPriority(Thread.MIN_PRIORITY);
		tm.start();
		tM.start();

	}

}
