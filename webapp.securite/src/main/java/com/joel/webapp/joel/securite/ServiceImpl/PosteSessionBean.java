/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.ServiceImpl;


import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import com.joel.webapp.joel.securite.Dao.IPosteDAO;
import com.joel.webapp.joel.securite.Service.PosteSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Poste;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PosteSessionBean extends BaseServiceBeanImpl<Poste, Long> implements PosteSessionBeanLocal {

    @EJB
    private IPosteDAO dao;

    @Override
    protected BaseDaoBean<Poste, Long> getDao() {
        return dao;
    }
}
