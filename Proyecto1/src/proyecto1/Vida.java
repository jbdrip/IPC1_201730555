/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static proyecto1.Tablero.matrizL;
import static proyecto1.Tablero.tam;

/**
 *
 * @author Javier
 */
public class Vida {

    public static int tam = 5;
    public JPanel fondoVidas = null;
    public static int[][] matrizL;
    public JLabel[][] matrizG;
    public int tambloqueY = 0;
    public Vida vida;

    public Vida() {

    }

    public Vida(int tam, JPanel panel) {
        this.tam = tam;
        this.fondoVidas = panel;
        llenar();
    }

    public void llenar() {
        tambloqueY = 100 / tam;
        matrizL = new int[tam][tam];
        matrizG = new JLabel[tam][tam];

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                matrizL[i][j] = 0;
            }
        }

        llenarVidas();
        vida = new Vida();
        repintar();
    }

    public void llenarVidas() {
        int cantVidas = 4;

        for (int j = 0; j <= cantVidas; j++) {
            matrizL[0][j] = 1;
            if(matrizL[0][4]==1){
                cantVidas++;
                matrizL[1][j]=1;
            }
            else if(matrizL[1][4]==1){
                cantVidas++;
                matrizL[2][j]=1;
            }
        }
    }

    public void repintar() {
        JLabel casilla = null;
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                //0 casilla vacia
                if (matrizL[i][j] == 0) {
                    casilla = new JLabel();
                } //2 vida
                else if (matrizL[i][j] == 1) {
                    casilla = new JLabel(this.vida.obtenerImagen(tambloqueY));
                }

                casilla.setOpaque(false);
                casilla.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                casilla.setBounds(j * tambloqueY, i * tambloqueY, tambloqueY, tambloqueY);

                matrizG[i][j] = casilla;
                fondoVidas.add(matrizG[i][j], BorderLayout.CENTER);
                fondoVidas.repaint();
            }
        }
    }

    public ImageIcon obtenerImagen(int tamy) {
        ImageIcon corazon = new ImageIcon(getClass().getResource("/images/corazon.png"));
        Image imagen = corazon.getImage();
        Image tamimagen = imagen.getScaledInstance(150, tamy, Image.SCALE_SMOOTH);
        corazon = new ImageIcon(tamimagen);
        return corazon;
    }

}
