/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;


import com.mycompany.controller.PinGenerator;
import com.mycompany.controllerImpl.PinGeneratorLocal;
import com.mycompany.util.ServiceResponse;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author therapy
 */
@Path("pin")
public class PinMgtResource {

    @Context
    private UriInfo context;
    
    @Inject
    PinGeneratorLocal pin;
    /**
     * Creates a new instance of PinMgtResource
     */
    public PinMgtResource() {
    }
    
     @POST
     @Path("generatepin")
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceResponse generatePin(
    @FormParam("prefix") String prefix,
                @FormParam("numberofpin") int numberOfPin 
    ) {
         ServiceResponse pinGeneration;
         try {
             pinGeneration= pin.pinGeneration(prefix,numberOfPin);
             
         } catch (Exception e) {
             pinGeneration=new ServiceResponse();
             pinGeneration.setResponseCode(10);
             pinGeneration.setResponseMessage(e.getMessage());
         }
       return pinGeneration;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    

}
