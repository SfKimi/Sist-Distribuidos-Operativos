package Jefe;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.DataOutputStream;
public class JefCliente implements Runnable {
private String host;
private String nota;
private int puerto;
    public JefCliente(int puerto,String host, String nota) {
        this.host = host;
        this.nota = nota;
        this.puerto = puerto;
    }
    @Override
    public void run() {
        //se crea un objeto de salida para la data "salida"
        DataOutputStream salida;
        try {
            //Crea el socket para conectarse con el cliente
            Socket sofi = new Socket(host, puerto);
            // en el objeto de salida out se le asigna una data que con el parametro get optiene lo que este en el canal
            //utilisando el socket creado y su hilo asociado
            salida = new DataOutputStream(sofi.getOutputStream());
            //Escribe en el canal con el comando write pasandole un string en la variable mensaje
            salida.writeUTF(nota);
            // cierra el socket para que el envio del mensaje se realice
            sofi.close();
        } catch (IOException ex) {
            Logger.getLogger(JefCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
