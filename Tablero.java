/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labdia8;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jose
 */
public class Tablero {
    public int tam=0;
    public JPanel fondo=null;
    public Personaje per;
  
    public int[] vecL;
    public JLabel[] vecG;
    
    public int tambloqueY=0;
    
    public Tablero(int tam, JPanel panel){
        this.tam=tam;
        this.fondo=panel;
        llenar();
    }
    
    public void llenar(){
        tambloqueY=800/tam;
        vecL=new int[tam];
        vecG=new JLabel[tam];
        
        //1 personaje 0 casillas vacias
        vecL[0]=1;
        
        per= new Personaje();
        per.posper=0;
        
        for(int i=1; i<tam; i++){
            vecL[i]=0;
        } 
        repintar();
    }
    
    public void repintar(){
        JLabel casilla=null;
        for(int i=0; i<tam; i++){
            //0 casilla vacia
            if(vecL[i]==0){
                casilla=new JLabel();
            }
            //1 personaje
            else{
                casilla=new JLabel(this.per.obtenerImagen(tambloqueY));
            }
            casilla.setOpaque(false);
            casilla.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
            casilla.setBounds(0,i*tambloqueY,150,tambloqueY);
            
            vecG[i]=casilla;
            fondo.add(vecG[i],BorderLayout.CENTER);
            fondo.repaint();
        }
    }
}
