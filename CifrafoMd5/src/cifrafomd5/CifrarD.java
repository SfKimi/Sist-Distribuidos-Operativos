/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrafomd5;

/**
 *
 * @author 310
 */
abstract class  CifrarD {
    
        String cadena;
        String pd="ADCDEFGHIJKLMNOPQRSTUV WXZYabcdefghijklmopqrstuvwxyz12345";
        String pc="1Aa2Dd3Cc4Dd5Ee6Ff7Gg8Hh9IiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxZzYy,;.+*/-";

    public CifrarD(String cadena) {
        this.cadena=cadena;
    }
        
    public abstract String Cifrar();
}
