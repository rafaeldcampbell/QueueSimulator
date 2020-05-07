/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordefilas;

import java.util.ArrayList;
import java.util.Scanner;


public class SimuladorDeFilas {
    
    private double esperancaW;
    private double esperancaN;
    private double descarteTotal;
    private double utilizacao;
    private final double utilizacaoFormula;
    private final int tamanhoLimiteFila;
    private final double taxaChegada;
    private final double taxaServico;
    private final double tempoChegada;
    private final double tempoServico;
    private final int numServidores;
    private final int tipoAtendimento;
    private final double tempoLimite;
    
    private ArrayList<Evento> listaEventos;
    
    private final int numeroExperimento;

    public SimuladorDeFilas(int tamanhoLimiteFila, double tempoChegada, double tempoServico, int numServidores, 
            int tipoAtendimento, double tempoLimite, int numeroExperimento) {
        this.tamanhoLimiteFila = tamanhoLimiteFila;
        this.taxaChegada = 1/tempoChegada;
        this.taxaServico = 1/tempoServico;
        this.tempoChegada = tempoChegada;
        this.tempoServico = tempoServico;
        this.numServidores = numServidores;
        this.tipoAtendimento = tipoAtendimento;
        this.tempoLimite = tempoLimite;
        this.numeroExperimento = numeroExperimento;
        this.utilizacaoFormula = taxaChegada/(taxaServico*numServidores);
        simula();
    }

    
    
    public void simula() {
      
        double minutos = 0.0;
        double fimAtendimento = 0.0;
       
        //para as medidas de interesse
        int elementos = 0;
        double tempoTotalServico = 0;
        int totalSaidas = 0;
        
        //gerador aleatorio
        GeradorAleatorio gerador = new GeradorAleatorio();
        
        //tempo medio de espera
        double tempoEsperaTotal = 0;
        int qtdTempoEspera = 0;
        
        
        //fila
        ArrayList<Elemento> filaElementos = new ArrayList<>();
        ArrayList<Elemento> listaAtendendo = new ArrayList<>();
        ArrayList<Elemento> remover = new ArrayList<>();
        int tamanhoLista = 0;
        
        //lista de eventos
        listaEventos = new ArrayList<>();
        
        //gera os primeiro caso de entrada e saida
        Elemento elem = new Elemento(gerador, taxaServico, taxaChegada, minutos);
        
        //numero medio de elementos
        int totalElementos = 0;
        double tempoAtual = 0;
        
        //utilização
        double tempoUtilizado = 0;
        
        
        while(minutos < tempoLimite){
            if(elem.getTempoChegada() <= minutos){ //processando chegadas na fila
                if(filaElementos.size() < tamanhoLimiteFila){
                    filaElementos.add(elem);
                    elementos += 1;
                    listaEventos.add(new Evento("chegada", minutos));
                }else{ //conta os descarte
                    descarteTotal += 1;
                }
                elem = new Elemento(gerador, taxaServico, taxaChegada, minutos);
            }
            
            if(listaAtendendo.size() < numServidores){ //verifica se tem servidor livre
                if(!filaElementos.isEmpty()){
                    int pos;
                    if(tipoAtendimento == 0){ //seguindo politica FIFO
                       pos = 0;
                    }else{ //seguindo politica LIFO
                        pos = filaElementos.size()-1;
                    }
                    filaElementos.get(pos).setTempoSaida(minutos);
                    listaAtendendo.add(filaElementos.get(pos));
                    filaElementos.remove(pos);
                }
            }
            for(Elemento ele : listaAtendendo){ //processa a saida dos atendimentos
                if(ele.getTempoSaida() <= minutos){
                    elementos -= 1;
                    remover.add(ele);
                    tempoEsperaTotal += ele.getTempoSaida() - ele.getTempoChegada();
                    qtdTempoEspera += 1;
                    listaEventos.add(new Evento("saida", minutos));
                }
            }
            remover.forEach((ele) -> { //remove os elementos que já sairam da lista
                listaAtendendo.remove(ele);
            });
            remover.clear();
            
            if(tempoAtual >= 1.0){
                totalElementos += elementos;
                tempoAtual = 0;
            }
            tempoUtilizado += (listaAtendendo.size()) * 0.001;
            
            tempoAtual += 0.001;
            minutos += 0.001; //atualiza o tempo
            
        }
        esperancaW = tempoEsperaTotal/qtdTempoEspera;
        esperancaN = totalElementos/tempoLimite;
        utilizacao = tempoUtilizado/(tempoLimite*numServidores);
    }
    public void imprimeInfos(){
        System.out.println("\n\n **** Experimento "+Integer.toString(numeroExperimento)+" ****");
        System.out.println("-- Entradas");
        System.out.println("Tamanho limite da fila: "+Double.toString(tamanhoLimiteFila));
        System.out.println("Tempo de chegada: "+Double.toString(tempoChegada));
        System.out.println("Tempo de serviço: "+Double.toString(tempoServico));
        System.out.println("Tipo de atendimento: "+ (tipoAtendimento == 0 ? "FIFO" : "LIFO"));
        System.out.println("Tempo limite: "+Double.toString(tempoLimite));
    }
    
    public void imprimeMedidas(){
        System.out.println("-- Medidas");
        System.out.println("Esperanca de W: "+Double.toString(esperancaW));
        System.out.println("Esperanca de N: "+Double.toString(esperancaN));
        System.out.println("Taxa de descarte: "+Double.toString(descarteTotal/60));
        System.out.println("Utilização: "+Double.toString(utilizacao));
        System.out.println("Utilização por fórmula: "+Double.toString(utilizacaoFormula));
    }
    
    public void imprimeEventos(){
        for(Evento ev : listaEventos){
            System.out.println(ev.getTipo()+" -> "+Double.toString(ev.getTempo()));
        }
    }

    public double getEsperancaW() {
        return esperancaW;
    }

    public double getTaxaChegada() {
        return taxaChegada;
    }
    
    
    
    
    
    
    
}
