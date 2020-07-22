
public class CuentaBancaria {
    private int saldo = 50;

    public int getSaldo() {
        return saldo;
    }

    public void retiro(int monto) {
        saldo = saldo - monto;
    }
}
