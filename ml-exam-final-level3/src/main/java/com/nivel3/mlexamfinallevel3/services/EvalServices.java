/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.services;


/*import com.
import com.nivel2.mlexamlevel3.entity.Human;
import com.nivel2.mlexamlevel3.entity.Mutant;
import com.nivel2.mlexamlevel3.model.Stats;
import com.nivel2.mlexamlevel3.validator.ValidateDna;*/
import com.nivel3.mlexamfinallevel3.dao.DynamoDao;
import com.nivel3.mlexamfinallevel3.entity.Human;
import com.nivel3.mlexamfinallevel3.entity.Mutant;
import com.nivel3.mlexamfinallevel3.model.Stats;
import com.nivel3.mlexamfinallevel3.validator.ValidateDna;
import java.util.Arrays;

/**
 *
 * @author AndrésJesús
 */
public class EvalServices {
    
  private ValidateDna adnValidator;
  private DynamoDao dynamoDao;
  
  public EvalServices(){
  adnValidator=new ValidateDna();
  dynamoDao=new DynamoDao();
  }
  /////////////////////////////////////////////////////////////////////
  public boolean isMutant(String []dna){
      boolean isMutant=adnValidator.isMutant(dna);
      if(!isMutant){
          dynamoDao.persistHuman(new Human(Arrays.toString(dna)));          
      }
      else{
          dynamoDao.persistMutant(new Mutant(Arrays.toString(dna)));
         }
         return isMutant;
  }
  /////////////////////////////////////////////////////////////////////
  public Stats getStats(){
   Stats stats=new Stats(dynamoDao.getMutant(),dynamoDao.getHumans());
  
  return stats;
  }
}
