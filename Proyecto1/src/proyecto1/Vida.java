/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Image;
import java.util.TreeSet;
import javax.swing.ImageIcon;

/**
 *
 * @author Javier
 */
public class Vida {
    public ImageIcon obtenerImagen(int tamy){
        ImageIcon corazon=new ImageIcon(getClass().getResource("/images/corazon.png"));
        Image imagen=corazon.getImage();
        Image tamimagen=imagen.getScaledInstance(150,tamy,Image.SCALE_SMOOTH);
        corazon=new ImageIcon(tamimagen);
        return corazon;
    }
}