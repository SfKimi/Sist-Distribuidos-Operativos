package Empleado;
import java.util.logging.Level;
import java.net.Socket;
import java.util.Observable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.ServerSocket;
public class EmpServidor extends Observable implements Runnable {
    //Se estable un puerto global a establecer para que el servidor escuche o respondza por el
    private int puerto;
    //constructor para definir un puerto al puerto global
    public EmpServidor(int puerto) {
        this.puerto = puerto;
    }
    @Override
    public void run() {
         //Se cre una variable de entrada de datos
        DataInputStream Entrada;
        //crea un server tipo socket y otro normal llamado kimi
        Socket Kimi = null;
        ServerSocket Serv = null;
        try {
            //Inicializamos el socket servidor global con un metodo que nos solicita el puerte para este lo escuche contantemente
            Serv = new ServerSocket(puerto);
            System.out.println("Servidor en Red");
            while (true) { //ciclo infinito
                //se igualan los socket tanto el server como el estandar para aceptar conexion.
                Kimi = Serv.accept();
                System.out.println("Cliente en Red");
                //le asignamos a a entrada de data  un input que obtrnga del socket pot medio de get
                Entrada = new DataInputStream(Kimi.getInputStream());
                //Ya almacenado el mensaje se almacena en un string y se lee con read
                String nota = Entrada.readUTF();
                System.out.println(nota);//se imprime el string wue contiene el mensaje
                this.setChanged();
                this.notifyObservers(nota);//se imprime el string wue contiene el mensaje
                this.clearChanged();
                //Cierro el socket para terminar la ejecucion del  mismo
                Kimi.close();
                //mensaje para comprobar que ha termionado la conexion del socket
                System.out.println("Cliente Fuera de Alcance");
            }
        } catch (IOException ex) {
            Logger.getLogger(EmpServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
