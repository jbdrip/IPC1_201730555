/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Movimiento extends Thread{
    public int cantidad=0;
    public Tablero tab=null;
    
    public Movimiento(int cantidad, Tablero tablero){
        this.cantidad=cantidad;
        this.tab=tablero;
    }
    
    public boolean comprobarfinx(Personaje personaje){
        if(personaje.posPersonajex>=tab.tam-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean comprobariniciox(Personaje personaje){
        if(personaje.posPersonajex<=0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean comprobarfiny(Personaje personaje){
        if(personaje.posPersonajey>=tab.tam-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean comprobarinicioy(Personaje personaje){
        if(personaje.posPersonajey<=0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void moverAbajo(int cantidad){
        tab.getPosicion();
        if(cantidad<=0){
            return;
        }
        if(comprobarfiny(tab.guerrero1)){
            cantidad=0;
            
            tab.matrizL[tab.tam-1][tab.guerrero1.posPersonajex]=0;
            tab.matrizG[tab.tam-1][tab.guerrero1.posPersonajex].setIcon(null);
            tab.guerrero1.posPersonajex=0;
            tab.guerrero1.posPersonajey=0;
            
            if(tab.tam%2==1){
                tab.matrizL[(tab.tam-1)-((tab.tam-1)/2)][(tab.tam-1)-((tab.tam-1)/2)]=7;
            }
            else{
                tab.matrizL[((tab.tam/2))][((tab.tam/2)+1)-1]=7;
            }
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                System.out.println(tab.guerrero1.posPersonajex+","+tab.guerrero1.posPersonajey);
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=0;
                tab.matrizG[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex].setIcon(null);
                tab.repintar();
                tab.guerrero1.posPersonajey+=1;
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=7;
                tab.repintar();
                cantidad--;
                Thread.sleep(5);
                
                moverAbajo(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void moverArriba(int cantidad){
        tab.getPosicion();
        if(cantidad<=0){
            return;
        }
        if(comprobarinicioy(tab.guerrero1)){
            cantidad=0;
            tab.matrizL[0][tab.guerrero1.posPersonajex]=0;
            tab.matrizG[0][tab.guerrero1.posPersonajex].setIcon(null);
            tab.guerrero1.posPersonajex=tab.tam-1;
            tab.guerrero1.posPersonajey=tab.tam-1;
            
            if(tab.tam%2==1){
                tab.matrizL[(tab.tam-1)-((tab.tam-1)/2)][(tab.tam-1)-((tab.tam-1)/2)]=7;
            }
            else{
                tab.matrizL[((tab.tam/2))][((tab.tam/2)+1)-1]=7;
            }
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=0;
                tab.matrizG[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex].setIcon(null);
                tab.repintar();
                tab.guerrero1.posPersonajey-=1;
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=7;
                tab.repintar();
                cantidad--;
                Thread.sleep(5);
                
                moverArriba(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void moverIzquierda(int cantidad){
        tab.getPosicion();
        if(cantidad<=0){
            return;
        }
        if(comprobariniciox(tab.guerrero1)){
            cantidad=0;
            tab.matrizL[tab.guerrero1.posPersonajey][0]=0;
            tab.matrizG[tab.guerrero1.posPersonajey][0].setIcon(null);
            tab.guerrero1.posPersonajex=tab.tam-1;
            tab.guerrero1.posPersonajey=tab.tam-1;
            
            if(tab.tam%2==1){
                tab.matrizL[(tab.tam-1)-((tab.tam-1)/2)][(tab.tam-1)-((tab.tam-1)/2)]=7;
            }
            else{
                tab.matrizL[((tab.tam/2))][((tab.tam/2)+1)-1]=7;
            }
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=0;
                tab.matrizG[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex].setIcon(null);
                tab.repintar();
                tab.guerrero1.posPersonajex-=1;
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=7;
                tab.repintar();
                cantidad--;
                Thread.sleep(5);
                
                moverIzquierda(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void moverDerecha(int cantidad){
        tab.getPosicion();
        if(cantidad<=0){
            return;
        }
        if(comprobarfiny(tab.guerrero1)){
            cantidad=0;
            
            tab.matrizL[tab.guerrero1.posPersonajey][tab.tam-1]=0;
            tab.matrizG[tab.guerrero1.posPersonajey][tab.tam-1].setIcon(null);
            tab.guerrero1.posPersonajex=0;
            tab.guerrero1.posPersonajey=0;
            
            if(tab.tam%2==1){
                tab.matrizL[(tab.tam-1)-((tab.tam-1)/2)][(tab.tam-1)-((tab.tam-1)/2)]=7;
            }
            else{
                tab.matrizL[((tab.tam/2))][((tab.tam/2)+1)-1]=7;
            }
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                System.out.println(tab.guerrero1.posPersonajex+","+tab.guerrero1.posPersonajey);
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=0;
                tab.matrizG[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex].setIcon(null);
                tab.repintar();
                tab.guerrero1.posPersonajex+=1;
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=7;
                tab.repintar();
                cantidad--;
                Thread.sleep(5);
                
                moverDerecha(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void run(){
        String Abajo="ab";
        String Arriba="ar";
        String Derecha="de";
        String Izquierda="iz";
        
        if(MediEvil.botonPulsado.equals(Abajo)){
            moverAbajo(cantidad);
        }
        else if(MediEvil.botonPulsado.equals(Arriba)){
            moverArriba(cantidad);
        }
        else if(MediEvil.botonPulsado.equals(Derecha)){
            moverDerecha(cantidad);
        }
        else if(MediEvil.botonPulsado.equals(Izquierda)){
            moverIzquierda(cantidad);
        }
    }
}
