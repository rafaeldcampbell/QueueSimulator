/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordefilas;

/**
 *
 * @author rafae
 */
public class Evento {
    
    private final String tipo;
    private final double tempo;
    
    public Evento(String tipo, double tempo){
        this.tipo = tipo;
        this.tempo = tempo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTempo() {
        return tempo;
    }
    
    
}
