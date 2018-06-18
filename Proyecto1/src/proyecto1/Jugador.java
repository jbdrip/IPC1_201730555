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
public class Jugador {
    private String nombre;
    public Personaje mago, princesa, guerrero;
    public int cantVidas=5;
    
    public Jugador(){
        cantVidas=5;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
