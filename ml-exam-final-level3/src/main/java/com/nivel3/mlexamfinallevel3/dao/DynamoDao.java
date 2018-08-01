/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivel3.mlexamfinallevel3.dao;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.nivel3.mlexamfinallevel3.entity.Human;
import com.nivel3.mlexamfinallevel3.entity.Mutant;



/**
 *
 * @author AndrésJesús
 */
public class DynamoDao {
    
    AmazonDynamoDB ddb;
    DynamoDBMapper mapper;
    
      /////////////////////////////////////////////////////////////////////
      public DynamoDao() {
        ddb = AmazonDynamoDBClientBuilder.standard()
                                         .withRegion(Regions.US_WEST_2)
                                         .build();
        mapper= new DynamoDBMapper(ddb);
       }
      /////////////////////////////////////////////////////////////////////
       public void persistHuman(Human human){
        mapper.save(human);    
       }
      /////////////////////////////////////////////////////////////////////
        public void persistMutant(Mutant mutant){
         mapper.save(mutant);    
        }
      /////////////////////////////////////////////////////////////////////
        public int getHumans(){
        DynamoDBScanExpression dbScanExpression = new DynamoDBScanExpression();
		return mapper.count(Human.class, dbScanExpression);
        }
       /////////////////////////////////////////////////////////////////////
        public int getMutant(){
        DynamoDBScanExpression dbScanExpression = new DynamoDBScanExpression();
		return mapper.count(Mutant.class, dbScanExpression);
        }
       /////////////////////////////////////////////////////////////////////
}
