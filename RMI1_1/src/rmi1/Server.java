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
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
///import javax.rmi.CORBA.Stub;
public class Server {
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

//Indica que se a inicializado el servidor 
        System.out.println("Iniciando servidor"); 
        
//Iincializa el metdo test remote para que esta puede aceder a lo que tenga testRemore con el objeto ObjCliente1
        Remote ObjCliente1 = UnicastRemoteObject.exportObject(new TestRemote() 
        {
///////El metodo mensaje saludo solo returna un mensaje con la variable name que es un string////////////////////////////
            @Override
            public String mensajeSaludo(String name) throws RemoteException {
                return "Hola hdfhasdhfksad , " + name;
            }
            
/////// el metodo get data 2 solo suma los numero en un for y lo regresa en un sum//////////////////////////////////////////
            public int getData2(int[]arr) throws RemoteException{
                int sum=0;
                for(int i=0;i<80;i++){
                  sum=sum+arr[i];  
                }
                
                return sum;
            }
            
///////Espacio para otros metodos////////////////////////////
           @Override
            public String Cifrar(String cadena) throws RemoteException {
                 CifradoDatos cd = new CifradoDatos(cadena);// crea objeto de Cifrado datos sonde esta el costrurtor que necesita parametro cadena 
                 //System.out.println("es cifrada:  "+ cd.Cifrar());//Utiliza uno de los metodos de cifrarDatos y lo imprime
                return cd.Cifrar();
            }
            
            
            
///////Espacio para otros metodos////////////////////////////
            @Override
            public String Decifrar(String cadenaD) throws RemoteException {
                 DecifradoDatos cd2 = new DecifradoDatos(cadenaD);// crea objeto de Cifrado datos sonde esta el costrurtor que necesita parametro cadena 
                 //System.out.println("es cifrada:  "+ cd.Cifrar());//Utiliza uno de los metodos de cifrarDatos y lo imprime
                 System.out.println("DecifradoServerAntesEnviar"+cd2.Decifrar());
                return cd2.Decifrar();
            }
        }, 0);
        
        
/////Crea un registro con el puerto definido para la conexion /////////////////////////
  
        //Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Registry registry = LocateRegistry.createRegistry(1099);
      
/////Establece ina contaseña para el registro creado en relacion al objeto remote objcliente1 que lo relaciona con test remore la clase en gris
        registry.bind("datoKey", ObjCliente1);
        
        
        
    }
}