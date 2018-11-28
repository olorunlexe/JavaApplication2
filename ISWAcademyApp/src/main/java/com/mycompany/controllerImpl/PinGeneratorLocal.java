/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllerImpl;

import com.mycompany.util.ServiceResponse;
import javax.ejb.Local;

/**
 *
 * @author therapy
 */
@Local
public interface PinGeneratorLocal {

    public ServiceResponse pinGeneration(String prefix, int numberOfPin);
    
}
