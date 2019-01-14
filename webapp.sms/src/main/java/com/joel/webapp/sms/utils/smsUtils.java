/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.sms.utils;

import com.joel.webapp.sms.Sms;

/**
 *
 * @author Mikel
 */
public class smsUtils {   

    public smsUtils() {
    }      
    
    /**
     * 
     * @param numeroTelephone numéro de téléphone du destinataire
     * @param msg le message a envoyer
     * @param user le user configuré dans le now sms
     * @param password le mot de passe configuré dans le now sms
     */
    
    public static void envoiMessage(String numeroTelephone, String msg, String user, String password) {

        Sms sms = new Sms();
        
        sms.init();
        sms.server = "http://127.0.0.1:8800/";
        sms.user = user;
        sms.password = password;
        sms.phonenumber = numeroTelephone;
        sms.text = msg;
        sms.send();
        //this.envoiSms= new EnvoiSms();
    }    
   
}
