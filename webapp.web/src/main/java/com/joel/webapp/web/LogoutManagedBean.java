/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.web;



import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
//import org.omnifaces.util.Faces;

/**
 *
 * @author Mikel | JoelKdb
 */

@ManagedBean
@RequestScoped
public class LogoutManagedBean{

    public void deconnexionUser() throws IOException {
//        Mtm.logMikiLog4j(LogoutManagedBean.class.getName(), Level.INFO, "Deconnexion");
//        EntityRealm.getSubject().logout();
//        Faces.invalidateSession();
//        Faces.redirect("index.xhtml");
    }
    
}
