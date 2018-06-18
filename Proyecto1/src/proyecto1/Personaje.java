/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Javier
 */
public class Personaje {
    public int posPersonajex;
    public int posPersonajey;
    public int turno;
    public Tablero tab;
    public Jugador jugador1, jugador2;
    
    public void ataqueGuerrero1(){
        tab.getPosicion();
        if((tab.matrizL[tab.guerrero1.posPersonajey+2][tab.guerrero1.posPersonajex+2]==4) || (tab.matrizL[tab.guerrero1.posPersonajey+2][tab.guerrero1.posPersonajex+2]==6) || (tab.matrizL[tab.guerrero1.posPersonajey+2][tab.guerrero1.posPersonajex+2]==8)){
            jugador2.cantVidas--;
            jugador2.cantVidas--;
        }
        else if((tab.matrizL[tab.guerrero1.posPersonajey-2][tab.guerrero1.posPersonajex]==4) || (tab.matrizL[tab.guerrero1.posPersonajey-2][tab.guerrero1.posPersonajex]==6) || (tab.matrizL[tab.guerrero1.posPersonajey-2][tab.guerrero1.posPersonajex]==8)){
            jugador2.cantVidas--;
            jugador2.cantVidas--;
        }
        else if((tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex+2]==4) || (tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex+2]==6) || (tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex+2]==8)){
            jugador2.cantVidas--;
            jugador2.cantVidas--;
        }
        else if((tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex-2]==4) || (tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex-2]==6) || (tab.matrizL[tab.guerrero1.posPersonajey][tab.guerrero1.posPersonajex-2]==8)){
            jugador2.cantVidas--;
            jugador2.cantVidas--;
        }
    }
    
    public ImageIcon obtenerImagenMago1(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/mago.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
    public ImageIcon obtenerImagenMago2(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/mago2.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
    public ImageIcon obtenerImagenPrincesa1(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/princesa.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
    public ImageIcon obtenerImagenPrincesa2(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/princesa2.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
     public ImageIcon obtenerImagenGuerrero1(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/guerrero.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
    public ImageIcon obtenerImagenGuerrero2(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/guerrero2.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    

}
