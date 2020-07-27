/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;

/**
 *
 * @author manue
 */
import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Applet {

    static String opcion;
    Label saludo = new Label("1.Saludar");
    Label suma = new Label("2.Sumar");
    Label palindrome = new Label("3.Encriptar y Desencriptar");
    Label jLabel = new Label("Ingrese requerimiento");
    static TextArea result = new TextArea();
    static TextArea result2 = new TextArea();
    TextField field = new TextField(20);
    Button button = new Button();

    
    
    public void init() {
        add(saludo);
        add(suma);
        add(palindrome);
        add(jLabel);
        add(field);
        add(button);
        add(result);
        add(result2);
    }

    public boolean action(Event event, Object ob) {

        if (event.target == button) {
            try {
                opcion = field.getText();
                operar();
                return true;
            } catch (RemoteException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    

    public void paint(Graphics g) {

    }
    
    
    
    
    public void operar() throws RemoteException, NotBoundException{
    
    Registry registry = LocateRegistry.getRegistry();

////se define el testremore1 con la interface TestRRemore
        TestRemote testRemote1 = (TestRemote) registry.lookup("datoKey");
        
///metodo que no importa tanto solo esta para probar
        int[] arr = new int[80];
        int m = 20;
        for (int i = 0; i < 80; i++) {
            arr[i] = m++;
        }

 /// para capturar la opcion que selecciono el usuario
        switch (opcion) {

            case "1":
                System.out.println("opcion 1");
                
                String re=testRemote1.mensajeSaludo("Emilio Barajasssss");
                System.out.println(re);
//se imprime en el aplett el resultado de la llamda a mensaje saludo que se acumula en "re"
                result.setText(re);

                break;

            case "2":

                System.out.println(testRemote1.getData2(arr));
                break;

            case "3":
                
////////////Procedimiento de cifrado/////
                  System.out.println("opcion 3");
                  Scanner sc =new Scanner(System.in);
                  String cadena;//////LA CADENA QUE SE ENVIA 
                  System.out.println("Digite");
                  cadena=sc.nextLine();// captura y guarda en cadena
                  String re2=testRemote1.Cifrar(cadena);
                System.out.println(re2);
                result.setText("Cadena Cifrada:"+re2);
////////////Procedimiento de Decifrado/////
                  String re4=testRemote1.Decifrar(re2);
                  System.out.println(re4);
                
//se imprime en el aplett el resultado de la llamda a mensaje saludo que se acumula en "re"
                  
                
                result2.setText("Cadena Decifrada:"+re4);
               
                break;

            default:

        }
        
// por que se crea un test remote 2
        TestRemote testRemote2 = (TestRemote) registry.lookup("datoKey");

    }

/*    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry();

        TestRemote testRemote1 = (TestRemote) registry.lookup("datoKey");

        System.out.println(testRemote1.mensajeSaludo("Emilio Barajasssss"));
        int[] arr = new int[80];
        int m = 20;
        for (int i = 0; i < 80; i++) {
            arr[i] = m++;
        }

        switch (opcion) {

            case "1":

                result.setText(testRemote1.mensajeSaludo("Juan Barajasssss"));

                break;
            case "2":

                System.out.println(testRemote1.getData2(arr));
                break;

            case "3":
                break;

            default:

        }
        TestRemote testRemote2 = (TestRemote) registry.lookup("datoKey");

    }*/

}
