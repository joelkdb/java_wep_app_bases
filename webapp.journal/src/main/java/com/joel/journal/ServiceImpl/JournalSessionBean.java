/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.journal.ServiceImpl;


import com.joel.journal.Dao.IJournalDAO;
import com.joel.journal.Service.JournalSessionBeanLocal;
import com.joel.journal.entities.Journal;
import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class JournalSessionBean extends BaseServiceBeanImpl<Journal, Long> implements JournalSessionBeanLocal {

    @EJB
    private IJournalDAO dao;

    @Override
    protected BaseDaoBean<Journal, Long> getDao() {
        return dao;
    }
}
