/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerImpl.PinGeneratorLocal;
import com.mycompany.model.PinTbl;
import com.mycompany.util.ServiceResponse;
import com.mycompany.util.Utility;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author therapy
 */
@Stateless
    public class PinGenerator implements PinGeneratorLocal {
    
    //it will accept twp parameters:prefix, the number of pin to generate.
     @PersistenceContext
    EntityManager em;
     @Override
     public ServiceResponse pinGeneration(String prefix, int numberOfPin){
         ServiceResponse response=new ServiceResponse();
         try {
             for (int i = 0; i < numberOfPin; i++) {
                String pinGen= Utility.pinGen(prefix);
                PinTbl pi=new PinTbl();
                pi.setPin(pinGen);
                pi.setPinExpiryDate(new Date());
                pi.setPinStatus("NEW");
                //set pin status:new
                em.persist(pi);
             }
             response.setResponseCode(0);
             response.setResponseMessage("Successful");
         } catch (Exception e) {
             System.out.println("error"+e.getMessage());
             response.setResponseCode(10);
             response.setResponseMessage("Failed to generate");
         }
         return response;
     }
    
}
