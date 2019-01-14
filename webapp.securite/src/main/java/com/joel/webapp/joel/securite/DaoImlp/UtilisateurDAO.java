/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.DaoImlp;


import com.joel.webapp.core.DaoImpl.BaseDaoBeanImpl;
import com.joel.webapp.joel.securite.Dao.IUtilisateurDAO;
import com.joel.webapp.joel.securite.entities.Utilisateur;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class UtilisateurDAO extends BaseDaoBeanImpl<Utilisateur, Long> implements IUtilisateurDAO {

    public UtilisateurDAO() {
        super(Utilisateur.class);
    }
    
}
