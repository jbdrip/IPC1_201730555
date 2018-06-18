/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class Cronometro extends Thread{
    JLabel label;
    int tiempo;

    public Cronometro(JLabel label, int tiempo) {
        this.tiempo = tiempo;
        this.label = label;
    }

    public void run() {
        int segundos = 60;
        int minutos = tiempo;
        for (int i = tiempo-1; i >=0; i--) {
            minutos = i;
            for (int j = 60; j >= 0; j--) {
                segundos = j;
                if (minutos < 10) {
                    if (segundos < 10) {
                        try {
                            label.setText("0"+minutos+":0"+segundos);
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            label.setText("0"+minutos+":"+segundos);
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    if (segundos < 10) {
                        try {
                            label.setText(minutos+":0"+segundos);
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        try {
                            label.setText(minutos+":"+segundos);
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por jugar el timpo ha acabado.");
    }
}
