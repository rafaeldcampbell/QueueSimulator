package simuladordefilas;

import java.util.Scanner;

public class Experimento {
    
    public static void executa(){
        Data data = new Data();
        //200 milissegundos -> 0.00333 minutos
        SimuladorDeFilas simulador = new SimuladorDeFilas(15, 0.00333, 0.0015, 1, 0, 60, 1);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        //180 milissegundos -> 0.003 minutos
        simulador = new SimuladorDeFilas(15, 0.003, 0.0015, 1, 0, 60, 2);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        //160 milissegundos -> 0.002666 minutos
        simulador = new SimuladorDeFilas(15, 0.002666, 0.0015, 1, 0, 60, 3);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        //140 milissegundos -> 0.002333 minutos
        simulador = new SimuladorDeFilas(15, 0.002333, 0.0015, 1, 0, 60, 4);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        //120 milissegundos -> 0.002 minutos
        simulador = new SimuladorDeFilas(15, 0.002, 0.0015, 1, 0, 60, 5);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        //100 milissegundos -> 0.001666 minutos
        simulador = new SimuladorDeFilas(15, 0.001666, 0.0015, 1, 0, 60, 6);
        simulador.imprimeInfos();
        simulador.imprimeMedidas();
        data.adiciona(simulador.getEsperancaW(), "", Double.toString(simulador.getTaxaChegada()));
        
        Scanner in = new Scanner(System.in);
        System.out.print("\n\nDeseja gerar gráfico? (s/n)");
        if(in.next().toLowerCase().equals("s")){
            GeraGrafico.GeraGrafico(data);
        }
    }
    
}
