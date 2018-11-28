/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerImpl.UserControllerLocal;
import com.mycompany.model.User;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author therapy
 */
@Stateless
public class UserController implements UserControllerLocal {

    @PersistenceContext
    EntityManager em;
    @Override
    public void createUser(String userName, String userPw, String userId){
        try {
            User u=new User();
            u.setPassword(userPw);
            u.setDateCreated(new Date());
            u.setUserName(userName);
            u.setUserId(userId);
            em.persist(u);
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
    }
}
