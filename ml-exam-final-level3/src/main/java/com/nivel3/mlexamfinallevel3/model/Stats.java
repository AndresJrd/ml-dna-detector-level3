/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author AndrésJesús
 */
public class Stats {
    private int count_mutant_dna;
    private int count_human_dna;
    private BigDecimal ratio;
  /////////////////////////////////////////////////////////////////////
    public Stats() {
    }

    public Stats(int count_mutant_dna, int count_human_dna) {
        this.count_mutant_dna = count_mutant_dna;
        this.count_human_dna =count_human_dna;
        if(count_human_dna!=0){
        this.ratio=((new BigDecimal(this.count_mutant_dna)).divide(new BigDecimal(this.count_human_dna), 1, RoundingMode.HALF_EVEN));
        }
        else
            this.ratio=BigDecimal.ZERO;                    
    }        
  /////////////////////////////////////////////////////////////////////      
    public int getCount_mutant_dna() {
        return count_mutant_dna;
    }
  /////////////////////////////////////////////////////////////////////
    public void setCount_mutant_dna(int count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }
  /////////////////////////////////////////////////////////////////////
    public int getCount_human_dna() {
        return count_human_dna;
    }
  /////////////////////////////////////////////////////////////////////
    public void setCount_human_dna(int count_human_dna) {
        this.count_human_dna = count_human_dna;
    }
  /////////////////////////////////////////////////////////////////////
    public BigDecimal getRatio() {
        return ratio;
    }
  /////////////////////////////////////////////////////////////////////
    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }
      /////////////////////////////////////////////////////////////////////
    
}
