/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.ServiceImpl;


import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import com.joel.webapp.joel.securite.Dao.IProfilDAO;
import com.joel.webapp.joel.securite.Service.ProfilSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Profil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class ProfilSessionBean extends BaseServiceBeanImpl<Profil, Long> implements ProfilSessionBeanLocal {

    @EJB
    private IProfilDAO dao;

    @Override
    protected BaseDaoBean<Profil, Long> getDao() {
        return dao;
    }
}
