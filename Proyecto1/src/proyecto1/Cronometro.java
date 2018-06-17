/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Javier
 */
public class Cronometro extends Thread{
    public int min;
    public int seg;
    
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
        }
        while(min>=0);
    }
}
