/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.web;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Mikel
 */
@ManagedBean
@ViewScoped
public class pageManagedBean implements Serializable {

    public pageManagedBean() {

    }

    
//    public String administrationPage() {
//        String cedric = null;
//        if (EntityRealm.getSubject().isPermitted(constante.ROLE_GESTION_ADMINISTRATION_CLE)) {
//            cedric = "Administration.xhtml";
//        } else {
//            cedric = "PageError.xhtml";
//        }
//        return cedric;
//    }
        

}
