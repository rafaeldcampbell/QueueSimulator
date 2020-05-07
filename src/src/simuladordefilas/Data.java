/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladordefilas;

import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author rafae
 */
public class Data extends DefaultCategoryDataset {
    
    
    public Data(){
        super();
    }
    
    public void adiciona(double valor, String linha, String x){
        this.addValue(valor, linha, x);
    }
    
    public DefaultCategoryDataset getData(){
        return this;
    }
    
}
