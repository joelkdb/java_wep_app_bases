/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.journal.DaoImpl;


import com.joel.journal.Dao.IJournalDAO;
import com.joel.journal.entities.Journal;
import com.joel.webapp.core.DaoImpl.BaseDaoBeanImpl;
import javax.ejb.Stateless;

/**
 *
 * @author Mikel
 */
@Stateless
public class JournalDAO extends BaseDaoBeanImpl<Journal, Long> implements IJournalDAO {

    public JournalDAO() {
        super(Journal.class);
    }
    
}
