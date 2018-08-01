package com.nivel3.mlexamfinallevel3;


import com.nivel3.mlexamfinallevel3.validator.ValidateDna;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndrésJesús
 */
public class ValidatorTest {
 String[] dnaMutant =  new String[] {"ATGCCA",
                                    "CAGTGC",
                                    "TTCTGG",
                                    "AAAAAG",
                                    "CCCCTA",
                                    "TCGCTG"};

 String[] dnaHuman =  new String[] {"ATGCCT", 
                                    "CAGTGC", 
                                    "TTCTGG", 
                                    "AGAAGG", 
                                    "CCCGTA", 
                                    "TCGCTG"};
    @Test
    public void evalMutante(){
        ValidateDna v=new ValidateDna();
        assertEquals( v.isMutant(dnaMutant),true);
    }
    
     @Test
    public void evalHumano(){
      ValidateDna v=new ValidateDna();
        assertEquals( v.isMutant(dnaHuman),false);
    }
}
