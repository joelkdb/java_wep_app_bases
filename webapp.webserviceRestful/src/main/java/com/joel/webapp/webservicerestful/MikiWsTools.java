/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.webservicerestful;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Mikel
 */
public class MikiWsTools {

    public MikiWsTools() {
    }

    /**
     * Cette methode permet de renvoyer sous format Json les données resultants de l'url passé en parametre
     * @param urlWebservice url du web service
     * @return le resultat sous format Json
     */
    public static String get(String urlWebservice) {
        try {

            URL url = new URL(urlWebservice);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Erreur -> HTTP code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            String output2 = "";
            while ((output = br.readLine()) != null) {
                output2 += output;
            }

            conn.disconnect();

            return output2;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cette methode permet d'ajouter un objet sous format json à une adresse (url du webservice)
     * @param urlWebservice url du webservice
     * @param json le json renfermant l'objet a ajouter
     * @return true si l'opération est un succès ou false sinon
     */
    public static boolean ajouter(String urlWebservice, String json) {
        try {

            URL url = new URL(urlWebservice);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = json;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
                throw new RuntimeException("Erreur -> HTTP code : "
                        + conn.getResponseCode());
            } else {
                System.out.println("Ajout éffectué avec succès !");
            }

            conn.disconnect();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

   /**
    * Cette methode permet de modifier un objet passé sous format json à une adresse (url du webservice)
    * @param urlWebservice url du webservice
    * @param json le json renfermant l'objet a modifier
    * @return true si l'opération est un succès ou false sinon
    */
    public static boolean modifier(String urlWebservice, String json) {
        final Gson gson = new GsonBuilder().create();
        try {

            URL url = new URL(urlWebservice);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = json;

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
                throw new RuntimeException("Erreur -> HTTP code : "
                        + conn.getResponseCode());
            } else {
                System.out.println("Modification éffectuée avec succès !");
            }

            conn.disconnect();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;

        }

    }

    /**
     * Cette methode permet de supprimer un objet à une adresse(url du webservice)
     * @param urlWebservice url du webservice
     * @return true si l'opération est un succès ou false sinon
     */
    public static boolean supprimer(String urlWebservice) {
        try {

            URL url = new URL(urlWebservice);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            if (conn.getResponseCode() != HttpURLConnection.HTTP_NO_CONTENT) {
                throw new RuntimeException("Erreur -> HTTP code : "
                        + conn.getResponseCode());
            } else {
                System.out.println("Suppression éffectuée avec succès !");
            }

            conn.disconnect();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    
}
