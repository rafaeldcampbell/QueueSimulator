/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordefilas;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GeraGrafico {
    
    public static void GeraGrafico(DefaultCategoryDataset ds){
        
        String x = "Taxa de chegada";
        String y = "Tempo médio de espera";
        
        //Cria um nome único para o gráfico
        Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat formatador = new SimpleDateFormat("dd_MM_YY_HH_mm_ss", locale);
        String nomeDoGrafico = "grafico_".concat(formatador.format(calendar.getTime())+".png"); 
        
        // cria o gráfico
        JFreeChart grafico = ChartFactory.createLineChart("", x, 
            y, ds, PlotOrientation.VERTICAL, false, true, false);
        
        OutputStream arquivo = null;
        try {           
            arquivo = new FileOutputStream("..\\Graficos\\"+nomeDoGrafico);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            System.out.println("\n** Gráfico gerado na pasta Graficos com o nome \"" + nomeDoGrafico + "\"");
        } catch (IOException ex) {
            Logger.getLogger(GeraGrafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
