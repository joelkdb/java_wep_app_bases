/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.Dao;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author user pc
 */
public class PersistenceUtil {
    public static final String UNIT_NAME = "";
    
    public static EntityManager createEm() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            return em;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceUtil.class.getName()).fatal(ex);
        }
        return null;
    }
}
