/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.ServiceImpl;


import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import com.joel.webapp.joel.securite.Dao.IDroitDAO;
import com.joel.webapp.joel.securite.Service.DroitSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Droit;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class DroitSessionBean extends BaseServiceBeanImpl<Droit, Long> implements DroitSessionBeanLocal {

    @EJB
    private IDroitDAO dao;

    @Override
    protected BaseDaoBean<Droit, Long> getDao() {
        return dao;
    }
}
