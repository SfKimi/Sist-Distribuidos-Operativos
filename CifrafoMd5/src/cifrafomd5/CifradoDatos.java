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
public class CifradoDatos extends CifrarD {

    public CifradoDatos(String cadena) {
        super(cadena);
    }

    public String Cifrar() {

        String cadenac = "";
        char c, cc;
        //System.out.println("cadena"+cadena);
        for (int i = 0; i < cadena.length(); i++) {
            cc = caractercifrado(cadena.charAt(i), cadena.length(), i);
            cadenac += cc;
        }
        //logica chart caracter almacenar recoorer por for 
        return cadenac;
    }
    
    private char caractercifrado(char c, int lon, int i) {
        char cc;
        if (pd.indexOf(String.valueOf(c)) < pc.length()) {
            int indice = pd.indexOf(c) + lon + i;
            cc = pc.charAt(indice);//equivalenvia debntro del alfa vifrado del numer equivalente de la formula indice
            return cc;
        }
        return c;
    }
}
