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
public class Bomba {
    public ImageIcon obtenerImagen(int tamy){
        ImageIcon bomba=new ImageIcon(getClass().getResource("/images/bomba.png"));
        Image imagen=bomba.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        bomba=new ImageIcon(tamimagen);
        return bomba;
    }
    
}
