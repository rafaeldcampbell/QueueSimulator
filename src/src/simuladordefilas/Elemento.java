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
public final class Elemento {
    
    private double tempoChegada;
    private double tempoServico;
    private double tempoSaida;
    
    public Elemento(GeradorAleatorio gerador, double taxaServico, double taxaChegada, double tempo){
        this.tempoChegada = geraChegada(gerador, taxaChegada) + tempo;
        this.tempoServico = geraServico(gerador, taxaServico);
    }

    public double getTempoChegada() {
        return tempoChegada;
    }

    public double getTempoServico() {
        return tempoServico;
    }

    public void setTempoSaida(double tempo){
        this.tempoSaida = tempo + tempoServico;
    }
    
    public double getTempoSaida(){
        return(this.tempoSaida);
    }

    public double geraServico(GeradorAleatorio gerador, double taxaServico){
        double exp = (Math.log(gerador.geraValor())/-taxaServico);
        return(Math.abs(exp));
    }
    
    public double geraChegada(GeradorAleatorio gerador, double taxaChegada){
        double exp = (Math.log(gerador.geraValor())/-taxaChegada);
        return(Math.abs(exp));
    }
}
