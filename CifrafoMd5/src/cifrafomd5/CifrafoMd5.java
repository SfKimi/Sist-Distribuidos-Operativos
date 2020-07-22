/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifrafomd5;

import java.util.Scanner;

/**
 *
 * @author 310
 */
public class CifrafoMd5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String cadena;
        System.out.println("Digite");
    cadena=sc.nextLine();
        CifradoDatos cd = new CifradoDatos(cadena);
        System.out.println("es cifrada:  "+ cd.Cifrar());
        // TODO code application logic here
    }
    
}
