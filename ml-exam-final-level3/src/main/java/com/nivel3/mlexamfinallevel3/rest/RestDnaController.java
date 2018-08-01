/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.rest;


import com.nivel3.mlexamfinallevel3.model.Adn;
import com.nivel3.mlexamfinallevel3.model.Stats;
import com.nivel3.mlexamfinallevel3.services.EvalServices;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author AndrésJesús
 */
@RestController
public class RestDnaController {
    
    private EvalServices evalServices;
  
    /**
     *
     * @param adn
     * @return HttpStatus
     */
    @PostMapping("/mutant")
    public @ResponseBody ResponseEntity<String> mutant( @RequestBody Adn adn) {
        System.out.println(""+Arrays.toString(adn.getAdn()));
        ResponseEntity<String> responseEntity;
        evalServices=new EvalServices();
        try{            
            if(evalServices.isMutant(adn.getAdn())){                
            responseEntity = new ResponseEntity<>(HttpStatus.OK);               
            }
            else{   
                 responseEntity = new ResponseEntity<>(HttpStatus.FORBIDDEN);                    
                }
           }
            catch(Exception exc){         
                System.out.println("ERROR:"+exc.toString());
                responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     }
        return responseEntity;
    
}
    
   ///////////////////////////////////////////////////////////////////// 
        @GetMapping("/stats")
    public Stats stats( Model model) {         
             evalServices=new EvalServices();
            return evalServices.getStats();                
    }
    /////////////////////////////////////////////////////////////////////
}


