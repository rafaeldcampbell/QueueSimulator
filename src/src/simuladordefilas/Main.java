package simuladordefilas;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {//recebendo os parametros da fila
        Scanner in = new Scanner(System.in);
        System.out.print("Deseja realizar experimento pré-programado? (s/n)");
        if(in.next().toLowerCase().equals("s")){
            Experimento.executa();
            return;
        }
        int numeroExperimentos = 0;
        SimuladorDeFilas simulador;
        int tamanhoLimiteFila;
        double tempoChegada;
        double tempoServico;
        int numServidores;
        int tipoAtendimento;
        int tempoLimite;
        Data data = new Data();
        
        do{
            System.out.print("Tamanho da fila: ");
            tamanhoLimiteFila = in.nextInt();
            System.out.print("Tempo médio de chegada: ");
            tempoChegada = in.nextDouble();
            System.out.print("Tempo médio de servico: ");
            tempoServico = in.nextDouble();
            System.out.print("Quantos servidores: ");
            numServidores = in.nextInt();
            System.out.print("FIFO(0) ou LIFO(1): ");
            tipoAtendimento = in.nextInt();
            System.out.print("Tempo de simulação: ");
            tempoLimite = in.nextInt();

            simulador = new SimuladorDeFilas(tamanhoLimiteFila, tempoChegada, tempoServico, numServidores, tipoAtendimento, tempoLimite, ++numeroExperimentos);
            simulador.imprimeInfos();
            simulador.imprimeMedidas();
            data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));

            System.out.println("\n\nDeseja imprimir backlog de eventos? (s/n)");
            if(in.next().toLowerCase().equals("s")){
                System.out.println("\n");
                simulador.imprimeEventos();
            }
            
            System.out.print("\n\nDeseja realizar novo experimento? (s/n)");
        } while(in.next().toLowerCase().equals("s"));
        
        if(numeroExperimentos > 1){
            System.out.print("\n\nDeseja gerar gráfico? (s/n)");
            if(in.next().toLowerCase().equals("s")){
                GeraGrafico.GeraGrafico(data);
            }
        }
    }    
}
