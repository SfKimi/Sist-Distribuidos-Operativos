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
public class DecifradoDatos extends DecifrarD1 {// Extiende de cifraD donde se encuantran los diccionarios pd y pc

    public DecifradoDatos(String cadena2) { ///constructor que resibe cadena
        super(cadena2);
    }

    public String Decifrar() {  // metodo de cifrar

        String cadenal = "";
        char c2, cc2;
        //System.out.println("cadena"+cadena);
        System.out.println("Cadena a Desifrar es:--> "+cadena2);
        for (int j = 0; j < cadena2.length(); j++) {
            cc2 = caracterdecifrado(cadena2.charAt(j), cadena2.length(), j);// lo envia a cifrar en el metodo caracter cifrar
            System.out.println(""+ cadena2.charAt(j) );//comprobcion de los caracteres
            cadenal += cc2;// imprime resultado cifrado
        }
        //logica chart caracter almacenar recoorer por for 
        return cadenal;
    }
    
    private char caracterdecifrado(char c3, int lon3, int i3) { // char c es la letra en sus diferentes posiciones
        char cc3;
        if (pd3.indexOf(String.valueOf(c3)) < pc3.length()) {// comprobrar que no deborde el el diccionario
            int indice3 = pc3.indexOf(c3) - lon3 - i3;// pd.indexof(c)posicion numerica del caracter c en el diccionario pd + lon total de la palabra + i nimero de la iteracion 
            cc3 = pd3.charAt(indice3);//equivalenvia dentro del alfab cifrado del numero equivalente de la formula indice basada en el diccionario numero 1
            return cc3; //retorna el caracter 
        }
        return c3;// si no cumple la condicion if solo retorna la letra tal cual la resibe 
    }
   
}
