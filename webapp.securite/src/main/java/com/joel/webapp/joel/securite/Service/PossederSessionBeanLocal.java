/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.Service;


import com.joel.webapp.core.Service.BaseServiceBean;
import com.joel.webapp.joel.securite.entities.Posseder;
import com.joel.webapp.joel.securite.entities.PossederId;
import javax.ejb.Local;

/**
 *
 * @author Mikel
 */
@Local
public interface PossederSessionBeanLocal extends BaseServiceBean<Posseder, PossederId>{
    
}
