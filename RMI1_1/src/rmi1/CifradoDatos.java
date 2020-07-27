/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi1;

/**
 *
 * @author 310
 */
public class CifradoDatos extends CifrarD {// Extiende de cifraD donde se encuantran los diccionarios pd y pc

    public CifradoDatos(String cadena) { ///constructor que resibe cadena
        super(cadena);
    }

    public String Cifrar() {  // metodo de cifrar

        String cadenac = "";
        char c, cc;
        //System.out.println("cadena"+cadena);
        for (int i = 0; i < cadena.length(); i++) {
            cc = caractercifrado(cadena.charAt(i), cadena.length(), i);// lo envia a cifrar en el metodo caracter cifrar
            System.out.println(""+ cadena.charAt(i) );//comprobcion de los caracteres
            cadenac += cc;// imprime resultado cifrado
        }
        //logica chart caracter almacenar recoorer por for 
        return cadenac;
    }
    
    
    
    
    
    private char caractercifrado(char c, int lon, int i) { // char c es la letra en sus diferentes posiciones
        char cc;
        if (pd.indexOf(String.valueOf(c)) < pc.length()) {// comprobrar que no deborde el el diccionario
            int indice = pd.indexOf(c) + lon + i;// pd.indexof(c)posicion numerica del caracter c en el diccionario pd + lon total de la palabra + i nimero de la iteracion 
            cc = pc.charAt(indice);//equivalenvia dentro del alfab cifrado del numero equivalente de la formula indice basada en el diccionario numero 1
            return cc; //retorna el caracter 
        }
        return c;// si no cumple la condicion if solo retorna la letra tal cual la resibe 
    }
    
    
    /*public String Decifrar() {  // metodo de cifrar

        String cadenac = "";
        char c, cc;
        //System.out.println("cadena"+cadena);
        for (int i = 0; i < cadena.length(); i++) {
            cc = caracterdecifrado(cadena.charAt(i), cadena.length(), i);// lo envia a cifrar en el metodo caracter cifrar
            System.out.println(""+ cadena.charAt(i) );//comprobcion de los caracteres
            cadenac += cc;// imprime resultado cifrado
        }
        //logica chart caracter almacenar recoorer por for 
        return cadenac;
    }
    
    
 private char caracterdecifrado(char c, int lon, int i) { // char c es la letra en sus diferentes posiciones
        char cc;
        if (pd.indexOf(String.valueOf(c)) < pc.length()) {// comprobrar que no deborde el el diccionario
            int indice = pc.indexOf(c) - lon - i;// pd.indexof(c)posicion numerica del caracter c en el diccionario pd + lon total de la palabra + i nimero de la iteracion 
            cc = pd.charAt(indice);//equivalenvia dentro del alfab cifrado del numero equivalente de la formula indice basada en el diccionario numero 1
            return cc; //retorna el caracter 
        }
        return c;// si no cumple la condicion if solo retorna la letra tal cual la resibe 
    }*/
    
    
    
    
    
    
}
