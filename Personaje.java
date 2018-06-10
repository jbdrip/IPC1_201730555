/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labdia8;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jose
 */
public class Personaje {
    public int posper=0;
    
    public ImageIcon obtenerImagen(int tamy){
        ImageIcon per=new ImageIcon(getClass().getResource("/Imagen/s2.jpg"));
        Image imagen=per.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        per=new ImageIcon(tamimagen);
        return per;
    }
}
