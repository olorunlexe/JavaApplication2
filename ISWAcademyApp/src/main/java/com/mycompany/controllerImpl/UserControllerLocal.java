/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllerImpl;

import javax.ejb.Local;

/**
 *
 * @author therapy
 */
@Local
public interface UserControllerLocal {

    public void createUser(String userName, String userPw, String userId);
    
}
