/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.DaoImlp;


import com.joel.webapp.core.DaoImpl.BaseDaoBeanImpl;
import com.joel.webapp.joel.securite.Dao.IPosteDAO;
import com.joel.webapp.joel.securite.entities.Poste;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class PosteDAO extends BaseDaoBeanImpl<Poste, Long> implements IPosteDAO {

    public PosteDAO() {
        super(Poste.class);
    }
    
}
