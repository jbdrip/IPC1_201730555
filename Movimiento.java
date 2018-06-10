/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labdia8;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Jose
 */
public class Movimiento extends Thread{
    public int cantidad=0;
    public Tablero tab=null;
    
    public Movimiento(int cantidad, Tablero tablero){
        this.cantidad=cantidad;
        this.tab=tablero;
    }
    
    public boolean comprobarfin(){
        if(tab.per.posper>=tab.tam-1){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean comprobarinicio(){
        if(tab.per.posper<=0){
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
        if(comprobarfin()){
            cantidad=0;
            tab.vecL[tab.tam-1]=0;
            tab.vecG[tab.tam-1].setIcon(null);
            tab.per.posper=0;
            tab.vecL[0]=1;
            tab.repintar();
            return;
        }
        else{
            try {
                //mover una posicion
                tab.vecL[tab.per.posper]=0;
                tab.vecG[tab.per.posper].setIcon(null);
                tab.repintar();
                tab.per.posper+=1;
                tab.vecL[tab.per.posper]=1;
                tab.repintar();
                cantidad--;
                Thread.sleep(500);
                
                moverAbajo(cantidad);
            } catch (InterruptedException ex) {
                Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void moverArriba(int cantidad){
        if(cantidad<=0){
            return;
        }
        if(comprobarinicio()){
            cantidad=0;
            tab.per.posper=0;
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
    }
    
    public void run(){
        String moverAbajo="moverAbajo";
        String moverArriba="moverArriba";
        if(NewJFrame.botonPulsado.equals(moverAbajo)){
            moverAbajo(cantidad);
        }
        else if(NewJFrame.botonPulsado.equals(moverArriba)){
            moverArriba(cantidad);
        }
        
    }
    
}
