/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Identidade;

/**
 *
 * @author Formação
 */
public class JavaApplication1 {

    static String obj1 = new String("xyz");
    static String obj2 = new String("xyz");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if (obj1 == obj2) {
            System.out.println("igual");
        } else {
            System.out.println("Diferente");
        }
    }

}
