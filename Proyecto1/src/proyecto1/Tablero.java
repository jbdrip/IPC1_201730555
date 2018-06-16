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
        matrizL[mago1.aleatorio.nextInt(tam)][mago1.aleatorio.nextInt(tam)]=3;
        mago1= new Personaje();
        mago1.posPersonajex=mago1.aleatorio.nextInt(tam);
        mago1.posPersonajey=mago1.aleatorio.nextInt(tam);
    
        //numero 4 mago jugador 2
        matrizL[mago2.aleatorio.nextInt(tam)][mago2.aleatorio.nextInt(tam)]=4;
        mago2= new Personaje();
        mago2.posPersonajex=mago2.aleatorio.nextInt(tam);
        mago2.posPersonajey=mago2.aleatorio.nextInt(tam);
        
        //numero 5 princesa jugador 1
        matrizL[princesa1.aleatorio.nextInt(tam)][princesa1.aleatorio.nextInt(tam)]=5;
        princesa1= new Personaje();
        princesa1.posPersonajex=princesa1.aleatorio.nextInt(tam);
        princesa1.posPersonajey=princesa1.aleatorio.nextInt(tam);
        
        //numero 6 princesa jugador 2
        matrizL[princesa2.aleatorio.nextInt(tam)][princesa2.aleatorio.nextInt(tam)]=6;
        princesa2= new Personaje();
        princesa2.posPersonajex=princesa2.aleatorio.nextInt(tam);
        princesa2.posPersonajey=princesa2.aleatorio.nextInt(tam);
        
        //numero 7 guerrero jugador 1
        matrizL[guerrero1.aleatorio.nextInt(tam)][guerrero1.aleatorio.nextInt(tam)]=7;
        guerrero1= new Personaje();
        guerrero1.posPersonajex=guerrero1.aleatorio.nextInt(tam);
        guerrero1.posPersonajey=guerrero1.aleatorio.nextInt(tam);
        
        //numero 8 guerrero jugador 2
        matrizL[guerrero2.aleatorio.nextInt(tam)][guerrero2.aleatorio.nextInt(tam)]=8;
        guerrero2= new Personaje();
        guerrero2.posPersonajex=guerrero2.aleatorio.nextInt(tam);  
        guerrero2.posPersonajey=guerrero2.aleatorio.nextInt(tam);
        
        bomba=new Bomba();
        vida = new Vida();
    
        repintar();
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
