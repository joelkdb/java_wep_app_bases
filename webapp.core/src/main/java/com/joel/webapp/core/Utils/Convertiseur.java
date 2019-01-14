/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.Utils;

import com.ibm.icu.text.RuleBasedNumberFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author MEDIA | JoelKdb
 */
public class Convertiseur {

    public static String formaterMonnaie(Double nombre) {
        try {
            NumberFormat instance = NumberFormat.getInstance();
            return instance.format(nombre) + " FCFA";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Convertie une monnaie en lettre(français)
     * @param nombre
     * @return
     */
    public static String formaterMonnaieLettre(Double nombre) {
        com.ibm.icu.text.NumberFormat format
                = new RuleBasedNumberFormat(Locale.FRANCE, RuleBasedNumberFormat.SPELLOUT);
        return format.format(nombre) + " FCFA";
    }

    /**
     * Convertie une monnaie en lettre(anglais)
     * @param nombre
     * @return
     */
    public static String formaterMonnaieLettreEn(Double nombre){
        com.ibm.icu.text.NumberFormat format
                = new RuleBasedNumberFormat(Locale.ENGLISH, RuleBasedNumberFormat.SPELLOUT);
        return format.format(nombre) + "FCFA";
    }

    /**     
     * @param date
     * @return l'heure d'une date sous la forme HH:MM:SS
     */
    public static String getHeure(Date date) {
        String heure = "" + date.getHours();
        String minute = "" + date.getMinutes();
        String second = "" + date.getSeconds();
        if (heure.length() == 1) {
            heure = "0" + heure;
        }
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        if (second.length() == 1) {
            second = "0" + second;
        }
        return heure + " :" + minute + " :" + second;

    }

    /**
     * @param date
     * @return une date sous la forme jj/mm/aaaa
     */
    public static String getDate(Date date) {

        String jour = "" + date.getDate();
        String mois = "" + (date.getMonth() + 1);
        String annee = "" + (date.getYear() + 1900);
        if (jour.length() == 1) {
            jour = "0" + jour;
        }
        if (mois.length() == 1) {
            mois = "0" + mois;
        }

        return jour + "/" + mois + "/" + annee;

    }
    
    /**
     * @param date
     * @return une date sous le format anglais aaaa/mm/jj
     */
    public static String getDateEn(Date date) {

        String jour = "" + date.getDate();
        String mois = "" + (date.getMonth() + 1);
        String annee = "" + (date.getYear() + 1900);
        if (jour.length() == 1) {
            jour = "0" + jour;
        }
        if (mois.length() == 1) {
            mois = "0" + mois;
        }

        return annee + "/" + mois + "/" + jour;

    }
}
