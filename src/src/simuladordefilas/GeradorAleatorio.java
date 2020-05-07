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
public class GeradorAleatorio {
    private final double m = 255;
    private double a = 359753158;
    private double c = 35;
    private double ultimoValor;
    
    public GeradorAleatorio(){
        this.ultimoValor =  System.currentTimeMillis(); //pega o horario do sistema em milisegundos
        
    }
    
    public double geraValor(){
        double val =  (((this.a * this.ultimoValor) + this.c) % this.m);
        this.ultimoValor = val;
        return val;
    }
}
