/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia21;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Dia21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pila pila = new Pila();
        Lista lista= new Lista();
        
        lista.imprimir();
        lista.insertarAlFrente(5);
        lista.insertarAlFinal(4);
        lista.insertarAlFinal(6);
        lista.insertarAlFrente(3);
        lista.insertarAlFrente(2);
        lista.insertarAlFrente(1);
        
        lista.imprimir();
        
        Object o;
        try{
            o=lista.removerAlFrente();
            int x= (int) o;
            System.out.println("\n elemento eliminado: "+x);
        }
        catch(Exception a){
            System.out.println(a.getMessage());
        }
        
        lista.imprimir();
        
        try {
            o=lista.removerAlFinal();
            int y = (int) o;
            System.out.println("\n elemento eliminado: "+y);
        } catch (Lista.ExceptionListaVacia ex) {
            Logger.getLogger(Dia21.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lista.imprimir();
      }
    
}
