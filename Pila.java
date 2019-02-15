/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia21;

import dia21.Lista.ExceptionListaVacia;

/**
 *
 * @author Jose
 */
public class Pila {
    private Lista pila;
    
    public Pila(){
        pila = new Lista("Pila");
    }
    
    public void push(Object dato){
        pila.insertarAlFrente(dato);
    }
    
    public Object pop()throws ExceptionListaVacia{
        return pila.removerAlFrente();
    }
}
