/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client;

import com.mycompany.controllerImpl.UserControllerLocal;
import com.mycompany.util.ServiceResponse;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author therapy
 */
@Path("user")
public class UserResources {

    @Context
    private UriInfo context;
    
    @Inject
    UserControllerLocal user;
    public UserResources() {
    }

 
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(
    
    @FormParam("userId")String userId,
                @FormParam("userName")String userName,
                        @FormParam("password")String password)
    {
        ServiceResponse response=new ServiceResponse();
        try {
            user.createUser(userName, password, userId);
            response.setResponseCode(0);
            response.setResponseMessage("Successful");
        } catch (Exception e) {
            response.setResponseCode(10);
            response.setResponseMessage("Error processing request");
        }
        return Response.ok(response).build();
    }


}
