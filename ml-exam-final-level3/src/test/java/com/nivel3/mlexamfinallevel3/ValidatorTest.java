package com.nivel2.mlexamfinallevel2;


import com.nivel2.mlexamfinallevel2.validator.ValidateDna;
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
 String[] dnaMutantI =  new String[] {
                                        "ATGCCA",
                                        "CAGTGC",
                                        "TTCTGG",
                                        "AAAAAG",
                                        "CCCCTA",
                                        "TCGCTG"};
 String[] dnaMutantII =  new String[]{
                                        "ATGCGA",
                                        "CAGTTC",
                                        "TTATTT",
                                        "AGTAGG",
                                        "GTGTAA",
                                        "TCACTG"};
 
    String[] dnaMutantIII =  new String[]{
                                        "ATGCGA",
                                        "CAGTGC",
                                        "GTTTTT",
                                        "AGACGG",
                                        "GGGGGA",
                                        "TCACTG"};
 
       String[] dnaHumanI =  new String[]  {
                                            "ATGCGA",
                                            "CAGTGC",
                                            "TTATTT",
                                            "AGACGG",
                                            "GCGTCA",
                                            "TCACTG"};
     String[] dnaHumanII =  new String[]  {
                                            "AACGAT",
                                            "TCGGAC",
                                            "TTATTT",
                                            "AGACGG",
                                            "AGTCCG",
                                            "TCACTG"};

     String[] dnaHumanIII =  new String[]  {
                                            "GTTTTT",
                                            "TCACTG",
                                            "ATGCGA",
                                            "GCGTCA",
                                            "ATGCGA",
                                            "AGAAGG"};
    @Test
    public void evalMutante(){
        ValidateDna v=new ValidateDna();
        assertEquals( v.isMutant(dnaMutantI),true);
        assertEquals( v.isMutant(dnaMutantII),true);
        assertEquals( v.isMutant(dnaMutantIII),true);
    }
    
     @Test
    public void evalHumano(){
      ValidateDna v=new ValidateDna();
        assertEquals( v.isMutant(dnaHumanI),false);
        assertEquals( v.isMutant(dnaHumanII),false);
        assertEquals( v.isMutant(dnaHumanIII),false);
    }
}
