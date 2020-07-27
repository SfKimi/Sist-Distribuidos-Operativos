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
import java.rmi.Remote;
import java.rmi.RemoteException;

/////NOMBRE DE LA INTERFACE QUE EXTIENDE DE REMOTE
public interface TestRemote extends Remote {
    
/////DEFINE LOS METODOS DE FORMA SIN DEFINIR PARA LOS QUE EXTIENDAN CON TESTREMORE  PUEDAN DEFINIR ESTOS Y DE IGUAL MANERA TIENEN QUE LLAMAR A REMOTE
   
////////METODO 2 DEFINIDO EN SERVER//////
    String mensajeSaludo(String name) throws RemoteException;
    
////////METODO 2 DEFINIDO EN SERVER//////
    public int getData2(int[] arr)throws RemoteException;

////////OTROS METODOS DEFINIDO EN SERVER//////
    String Cifrar(String cadena) throws RemoteException;
   
////////OTROS METODOS DEFINIDO EN SERVER//////
    String Decifrar(String cadena2) throws RemoteException;
    
    
    
}
