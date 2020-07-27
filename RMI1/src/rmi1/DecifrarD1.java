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
abstract class  DecifrarD1 {
    
        String cadena2;
        String pd3="ADCDEFGHIJKLMNOPQRSTUV WXZYabcdefghijklmopqrstuvwxyz123456789,;.+*/-"; //Diccionario base del cual se sacrala posicion para la formula
        String pc3="1Aa2Dd3Cc4Dd5Ee6Ff7Gg8Hh9IiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxZzYy,;.+*/-";// Diccionario de donde se buscara el acaracter equivalente al numero resultantes de la formula

    public DecifrarD1(String cadena2) {
        this.cadena2=cadena2;
    }
        
    public abstract String Decifrar();
    
}
