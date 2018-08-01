/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


/**
 *
 * @author AndrésJesús
 */
@DynamoDBTable(tableName="Mutant")
public class Mutant {

    private String dna;
/////////////////////////////////////////////////////////////////////
    public Mutant() {
    }
/////////////////////////////////////////////////////////////////////
    public Mutant(String dna) {
        this.dna = dna;
    }
/////////////////////////////////////////////////////////////////////
   @DynamoDBHashKey(attributeName="dna")
    public String getDna() {
        return dna;
    }
/////////////////////////////////////////////////////////////////////
    public void setDna(String dna) {
        this.dna = dna;
    }
/////////////////////////////////////////////////////////////////////
       
}