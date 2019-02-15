package dia21;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier
 */
public class Nodo {
 
    public Object dato;
    public Nodo siguiente,anterior;
    
    public Nodo(Object dato, Nodo siguiente, Nodo anterior){
        setDato(dato);
        setSiguiente(siguiente);
        setAnterior(anterior);
    }
    
    public Nodo(Object dato){
        setDato(dato);
        setSiguiente(null);
        setAnterior(null);
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    
    
}
