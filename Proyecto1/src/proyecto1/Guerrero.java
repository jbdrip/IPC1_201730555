/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Javier
 */
public class Guerrero {
    public int posGuerrero=0;
    
    public ImageIcon obtenerImagen1(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/guerrero.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
    
    public ImageIcon obtenerImagen2(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/images/guerrero2.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
}
