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
    
    public boolean comprobarfiny(Personaje personaje){
        if(personaje.posPersonajey>=tab.tam-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean comprobarinicio(Personaje personaje){
        if((personaje.posPersonajex<=0) || (personaje.posPersonajey<=0)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void moverAbajo(int cantidad){
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
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=0;
                tab.matrizG[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex].setIcon(null);
                tab.repintar();
                tab.guerrero1.posPersonajey+=1;
                tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex]=7;
                tab.repintar();
                cantidad--;
                Thread.sleep(1);
                
                moverAbajo(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /*public void moverArriba(int cantidad){
        if(cantidad<=0){
            return;
        }
        if(comprobarinicio()){
            cantidad=0;
            tab.vecL[0]=0;
            tab.vecG[0].setIcon(null);
            tab.per.posper=tab.tam-1;
            tab.vecL[tab.tam-1]=0;
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                tab.vecL[tab.per.posper]=0;
                tab.vecG[tab.per.posper].setIcon(null);
                tab.repintar();
                tab.per.posper-=1;
                tab.vecL[tab.per.posper]=1;
                tab.repintar();
                cantidad--;
                Thread.sleep(500);
                
                moverArriba(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    
    public void run(){
        String moverAbajo="ab";
        String moverArriba="Arriba";
        if(MediEvil.botonPulsado.equals(moverAbajo)){
            moverAbajo(cantidad);
        }
//        else if(MediEvil.botonPulsado.equals(moverArriba)){
//            moverArriba(cantidad);
//        }
        //moverAbajo(cantidad);
        //moverArriba(cantidad);        
    }
}
