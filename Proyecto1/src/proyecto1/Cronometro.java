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
public class Cronometro extends Thread{
    public int min=2;
    public int seg=60;
    
    public void run(){
        do{
            if(seg!=0){
                seg--;
            }else{
                if(min!=0){
                    seg=59;
                    min--;
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(min>=0);
    }
}
