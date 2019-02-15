/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia21;

/**
 *
 * @author Jose
 */
public class Lista {
    
    private String nombre;
    private Nodo ini,fin;
    
    public Lista(String nombre){
        this.nombre=nombre;
    }
    
    public Lista(){
        this("Lista");
    }
    
    public boolean estaVacia(){
        return null == ini;
    }
    
    public void insertarAlFrente(Object dato){
        if(estaVacia())
            ini = fin = new Nodo(dato);
        else
            ini = new Nodo(dato, ini, null);
    }
    
    public void insertarAlFinal(Object dato){
        if(estaVacia())
            ini = fin = new Nodo(dato);
        else
            fin = fin.siguiente = new Nodo(dato,null,fin);     
    }
    
    public void imprimir(){
        Nodo actual = ini;
        
        if(actual==null){
            System.out.println("La "+nombre+ " esta vacia.");
            return;
        }
        
        System.out.println("Contenido");
        while(actual!=null){
            System.out.println(" "+actual.getDato());
            actual = actual.siguiente;
        }
    }
    
    public Object removerAlFrente() throws ExceptionListaVacia{
        if(estaVacia())
            throw new ExceptionListaVacia(nombre);
        
        Object dato = ini.getDato();
        
        if(ini == fin)
            ini = fin = null;
        
        else
            ini = ini.siguiente;
        
        return dato;
    }
    
    public Object removerAlFinal() throws ExceptionListaVacia{
        if(estaVacia())
            throw new ExceptionListaVacia(nombre);
        
        Object dato = fin.getDato();
        
        if(ini==fin)
            ini = fin = null;
        
        else{
            fin = fin.anterior;
            fin.siguiente=null;
        }
           
        
        
        return dato;
    }
    
    class ExceptionListaVacia extends Exception{
        
        public ExceptionListaVacia(String nombre){
            super("La "+nombre+" esta vacia");
        }
    }
}
