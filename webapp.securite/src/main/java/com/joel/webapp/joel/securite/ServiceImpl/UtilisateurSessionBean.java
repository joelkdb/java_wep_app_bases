/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.ServiceImpl;


import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.ServiceImpl.BaseServiceBeanImpl;
import com.joel.webapp.joel.securite.Dao.IUtilisateurDAO;
import com.joel.webapp.joel.securite.Service.UtilisateurSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Utilisateur;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class UtilisateurSessionBean extends BaseServiceBeanImpl<Utilisateur, Long> implements UtilisateurSessionBeanLocal {

    @EJB
    private IUtilisateurDAO dao;

    @Override
    protected BaseDaoBean<Utilisateur, Long> getDao() {
        return dao;
    }
}
