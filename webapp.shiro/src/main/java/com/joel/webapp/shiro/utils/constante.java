/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.shiro.utils;

import java.io.Serializable;

/**
 *
 * @author Mikel
 */
public abstract class constante implements Serializable{
    
    public static final String ROLE_ALL = "Tous";
    public static final String ROLE_ALL_CLE = "*";
    
    
//    public static final String ROLE_CREER_- = "Ajouter un -";
//    public static final String ROLE_MODIFIER_- = "Modifier un -";
//    public static final String ROLE_CONSULTER_- = "Consulter un -";
//    public static final String ROLE_IMPRIMER_- = "Imprimer un -";
//    
//    public static final String ROLE_CREER_-_CLE = "-:ajout";
//    public static final String ROLE_MODIFIER_-_CLE = "-:modification";
//    public static final String ROLE_CONSULTER_-_CLE = "-:consultation";
//    public static final String ROLE_IMPRIMER_-_CLE = "-:impression";
      
    
    public static final String ROLE_GESTION_SECURITE = "Gestion de la sécurité";
    public static final String ROLE_GESTION_SECURITE_CLE = "securite:*";
    
   
    public static final String MOT_DE_PASSE_DEFAUT = "";

    public constante() {
    }
   
}
