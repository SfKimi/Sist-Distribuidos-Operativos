package Empleado;
import java.io.DataInputStream;
import java.util.logging.Level;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;
import java.io.DataOutputStream;
public class EmpCliente implements Runnable {
private String host;
private String nota;
private int puerto;
//constructtor que resibe el llamado para definir las variables globales puertp, host y mensaje
// mensaje es el mas importante ya que contirene el mensaje capturado que se desea enviar al cliente
    public EmpCliente(int puerto, String host, String nota) {
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
            Socket Kimi = new Socket(host, puerto);
            // en el objeto de salida out se le asigna una data que con el parametro get optiene lo que este en el canal
            //utilisando el socket creado y su hilo asociado
            salida = new DataOutputStream(Kimi.getOutputStream());
            //Escribe en el canal con el comando write pasandole un string en la variable mensaje
            salida.writeUTF(nota);
            // cierra el socket para que el envio del mensaje se realice
            Kimi.close();
        } catch (IOException ex) {
            Logger.getLogger(EmpCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
