/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Javier
 */
public class Tablero{
    public static int tam=0;
    public JPanel fondo=null;
    public Personaje mago1, mago2, princesa1, princesa2, guerrero1, guerrero2;
    public Bomba bomba;
    public Vida vida;
   
    public static int[][] matrizL;
    public JLabel[][] matrizG;
    
    public int tambloqueY=0;
    
    
    public Tablero(int tam, JPanel panel){
        this.tam=tam;
        this.fondo=panel;
        llenar();
    }
    
    public  void llenar(){
        tambloqueY=550/tam;
        matrizL=new int[tam][tam];
        matrizG=new JLabel[tam][tam];
        Random aleatorio=new Random();
        
        //numero 0 casillas vacias
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
               matrizL[i][j]=0; 
            } 
        }
        
        llenarBombas();
        llenarVidas();
        
        //numero 3 mago jugador 1
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=3;
        mago1= new Personaje();
    
        //numero 4 mago jugador 2
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=4;
        mago2= new Personaje();
        
        //numero 5 princesa jugador 1
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=5;
        princesa1= new Personaje();
        
        //numero 6 princesa jugador 2
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=6;
        princesa2= new Personaje();
        
        //numero 7 guerrero jugador 1
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=7;
        guerrero1= new Personaje();
        
        //numero 8 guerrero jugador 2
        matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=8;
        guerrero2= new Personaje();
        
        bomba=new Bomba();
        vida = new Vida();
    
        repintar();
    }
    
    public void getPosicion(){
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                switch (matrizL[i][j]) {
                    case 3:
                        mago1.posPersonajex=j;
                        mago1.posPersonajey=i;
                        break;
                    case 4:
                        mago2.posPersonajex=j;
                        mago2.posPersonajey=i;
                        break;
                    case 5:
                        princesa1.posPersonajex=j;
                        princesa1.posPersonajey=i;
                        break;
                    case 6:
                        princesa2.posPersonajex=j;
                        princesa2.posPersonajey=i;
                        break;
                    case 7:
                        guerrero1.posPersonajex=j;
                        guerrero1.posPersonajey=i;
                        break;
                    case 8:
                        guerrero2.posPersonajex=j;
                        guerrero2.posPersonajey=i;
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public void llenarBombas(){
        int cantBombas=(int) ((tam*tam)*0.1);
        Random aleatorio=new Random();
        for(int i=0; i<=cantBombas; i++){
            matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=1; 
        }  
    }
    
    public void llenarVidas(){
        int cantVidas=(int) ((tam*tam)*0.05);
        Random aleatorio=new Random();
        for(int i=0; i<=cantVidas; i++){
            matrizL[aleatorio.nextInt(tam)][aleatorio.nextInt(tam)]=2; 
        }   
    }
    
    public void repintar(){
        JLabel casilla=null;
        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
               //0 casilla vacia
            if(matrizL[i][j]==0){
                casilla=new JLabel();
            }
            //1 bomba
            if(matrizL[i][j]==1){
                casilla=new JLabel(this.bomba.obtenerImagen(tambloqueY));
            }
            //2 vida
            if(matrizL[i][j]==2){
                casilla=new JLabel(this.vida.obtenerImagen(tambloqueY));
            }
            //3 mago jugador 1
            if(matrizL[i][j]==3){
                casilla=new JLabel(this.mago1.obtenerImagenMago1(tambloqueY));
            }
            //4 mago jugador 2
            if(matrizL[i][j]==4){
                casilla=new JLabel(this.mago2.obtenerImagenMago2(tambloqueY));
            }
            //5 princesa jugador 1
            if(matrizL[i][j]==5){
                casilla=new JLabel(this.princesa1.obtenerImagenPrincesa1(tambloqueY));
            }
            //6 princesa jugador 2
            if(matrizL[i][j]==6){
                casilla=new JLabel(this.princesa2.obtenerImagenPrincesa2(tambloqueY));
            }
            //7 guerrero jugador 1
            if(matrizL[i][j]==7){
                casilla=new JLabel(this.guerrero1.obtenerImagenGuerrero1(tambloqueY));
            }
            //8 guerrero jugador 2
            if(matrizL[i][j]==8){
                casilla=new JLabel(this.guerrero2.obtenerImagenGuerrero2(tambloqueY));
            }
            
            casilla.setOpaque(false);
            casilla.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
            casilla.setBounds(j*tambloqueY,i*tambloqueY,tambloqueY,tambloqueY);
            
            matrizG[i][j]=casilla;
            fondo.add(matrizG[i][j],BorderLayout.CENTER);
            fondo.repaint(); 
            } 
        }
    }
}
