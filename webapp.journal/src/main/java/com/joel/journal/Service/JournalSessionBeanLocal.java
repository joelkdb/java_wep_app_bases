/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.journal.Service;


import com.joel.journal.entities.Journal;
import com.joel.webapp.core.Service.BaseServiceBean;
import javax.ejb.Local;

/**
 *
 * @author Mikel
 */
@Local
public interface JournalSessionBeanLocal extends BaseServiceBean<Journal, Long>{
    
}
