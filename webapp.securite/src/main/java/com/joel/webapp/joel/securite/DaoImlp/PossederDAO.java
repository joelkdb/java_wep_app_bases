/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.joel.securite.DaoImlp;

import com.joel.webapp.core.DaoImpl.BaseDaoBeanImpl;
import com.joel.webapp.joel.securite.Dao.IPossederDAO;
import com.joel.webapp.joel.securite.entities.Posseder;
import com.joel.webapp.joel.securite.entities.PossederId;
import javax.ejb.Stateless;



/**
 *
 * @author Mikel
 */
@Stateless
public class PossederDAO extends BaseDaoBeanImpl<Posseder, PossederId> implements IPossederDAO {

    public PossederDAO() {
        super(Posseder.class);
    }
    
}
