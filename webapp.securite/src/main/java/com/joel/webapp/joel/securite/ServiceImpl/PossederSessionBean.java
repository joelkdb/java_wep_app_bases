/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.ServiceImpl;


import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import com.joel.webapp.joel.securite.Dao.IPossederDAO;
import com.joel.webapp.joel.securite.Service.PossederSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Posseder;
import com.joel.webapp.joel.securite.entities.PossederId;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PossederSessionBean extends BaseServiceBeanImpl<Posseder, PossederId> implements PossederSessionBeanLocal {

    @EJB
    private IPossederDAO dao;

    @Override
    protected BaseDaoBean<Posseder, PossederId> getDao() {
        return dao;
    }
}
