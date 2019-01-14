/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.web;

import com.joel.webapp.core.Utils.Mtm;
import com.joel.webapp.joel.securite.Service.DroitSessionBeanLocal;
import com.joel.webapp.joel.securite.Service.PossederSessionBeanLocal;
import com.joel.webapp.joel.securite.Service.PosteSessionBeanLocal;
import com.joel.webapp.joel.securite.Service.ProfilSessionBeanLocal;
import com.joel.webapp.joel.securite.Service.UtilisateurSessionBeanLocal;
import com.joel.webapp.joel.securite.entities.Droit;
import com.joel.webapp.joel.securite.entities.Posseder;
import com.joel.webapp.joel.securite.entities.PossederId;
import com.joel.webapp.joel.securite.entities.Poste;
import com.joel.webapp.joel.securite.entities.Profil;
import com.joel.webapp.joel.securite.entities.Utilisateur;
import java.io.IOException;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.log4j.Level;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
//import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Mikel
 */
@ManagedBean(name = "connexionManagedBean")
@SessionScoped
public class ConnexionManagedBean implements Serializable {

    private Utilisateur userConnexion, userConnexionTest, user;
    private Profil profilUtilisateur;
    private Profil profil2;
    private Posseder posseder;
    private PossederId possederId;
    private List<Droit> droitUtilisateurs2;
    private List<Poste> postes;
    private List<Profil> profilList;
    private List<Utilisateur> users;
    private Poste poste;
    private String tofProfil;
    private String userProfil;
    private String userLogin;
    private String userPoste;
    private Utilisateur persUser;
    private Droit droitTous;
    private String newMdp;
    private String comfMdp;

    @EJB
    private DroitSessionBeanLocal droitUtilisateurServices;
    @EJB
    private UtilisateurSessionBeanLocal userServices;
    @EJB
    private UtilisateurSessionBeanLocal utilisateurServices;
    @EJB
    private PossederSessionBeanLocal possederServices;
    @EJB
    private ProfilSessionBeanLocal profilUtilisateurServices;
    @EJB
    private PosteSessionBeanLocal posteServices;
//    @EJB
//    private JournalSessionBeanLocal journalServices;

    public ConnexionManagedBean() {
        userConnexion = new Utilisateur();
        userConnexionTest = new Utilisateur();
        persUser = new Utilisateur();
        user = new Utilisateur();
        posseder = new Posseder();
        possederId = new PossederId();
        profilUtilisateur = new Profil();
        profil2 = new Profil();
        droitTous = new Droit();
        droitUtilisateurs2 = new ArrayList<>();
//        tofProfil = "images/tofProfilDefaut.png";
        postes = new ArrayList<>();
        profilList = new ArrayList<>();
        users = new ArrayList<>();
        poste = new Poste();
    }

    @PostConstruct
    public void init() {
//        List<Droit> droitUsers = droitUtilisateurServices.getAll();
//
//        if (droitUsers.isEmpty()) {            
//            droitUtilisateurServices.saveOne(new Droit(constante.ROLE_ALL, constante.ROLE_ALL_CLE));
//            
//        }
//
//        postes = posteServices.getAll();
//        if (postes.isEmpty()) {
//            poste.setLibPoste("Administrateur");
//            posteServices.saveOne(poste);
//        }
//
//        profilList = profilUtilisateurServices.getAll();
//        if (profilList.isEmpty()) {
//            profilUtilisateur.setNomProf("Admin");
//            profilUtilisateur.setDateCreaProf(new Date());
//            profilUtilisateurServices.saveOne(profilUtilisateur);
//
//            droitUtilisateurs2 = droitUtilisateurServices.getNonBy("libDroit", "Tous");
//
//            for (Droit drt : droitUtilisateurs2) {
//                possederId.setProfilID(profilUtilisateur.getIdProf());
//                possederId.setDroitUtilID(drt.getCodeDroit());
//                posseder.setId(possederId);
//                posseder.setProfil(profilUtilisateur);
//                posseder.setDroitUtilisateur(drt);
//
//                this.possederServices.saveOne(posseder);
//
//                posseder = new Posseder();
//                possederId = new PossederId();
//            }
//
//            profilUtilisateurServices.saveOne(new Profil("Invite","Pour les utilisateurs qui n'ont pas de droit", new Date()));
//
//            List<Posseder> poss = possederServices.getBy("profil", profilUtilisateur);
//            for (Posseder po : poss) {
//                profilUtilisateur.ajouterPosseder(po);
//                profilUtilisateurServices.updateOne(profilUtilisateur);
//            }
//
//            profil2.setNomProf("All_privilege");
//            profil2.setDateCreaProf(new Date());
//            profilUtilisateurServices.saveOne(profil2);
//
//            droitTous = droitUtilisateurServices.getOneBy("libDroit", "Tous");
//
//            possederId.setProfilID(profil2.getIdProf());
//            possederId.setDroitUtilID(droitTous.getCodeDroit());
//            posseder.setId(possederId);
//            posseder.setProfil(profil2);
//            posseder.setDroitUtilisateur(droitTous);
//
//            this.possederServices.saveOne(posseder);
//
//            posseder = new Posseder();
//            possederId = new PossederId();
//
//            List<Posseder> poss2 = possederServices.getBy("profil", profil2);
//            for (Posseder po2 : poss2) {
//                profil2.ajouterPosseder(po2);
//                profilUtilisateurServices.updateOne(profil2);
//            }
//        }
//
//        users = userServices.getAll();
//        if (users.isEmpty()) {
//           user.setNom("Admin");
//        user.setPrenom("Admin");
//        user.setSexe("-");
//        user.setLogin("Administrateur");
//        user.setPoste(poste);
//        user.setMotDePasse(new Sha256Hash(constante.MOT_DE_PASSE_DEFAUT).toHex());
//        user.setDateCreation(new Date());
//        user.setReinitialiserPswd(true);
//        user.setActif(true);
//        user.setPhoto(tofProfil);
//        user.setProfil(profil2);
//
//            this.userServices.saveOne(user);
//
//        }
//
//        user = new Utilisateur();
//        poste = new Poste();
//        profilUtilisateur = new Profil();
//        profil2 = new Profil();
//        droitTous = new Droit();
//        droitUtilisateurs2 = new ArrayList<>();

    }

    public void connexionUser() throws IOException {
        UsernamePasswordToken token = new UsernamePasswordToken(userConnexion.getLogin().trim(), userConnexion.getMotDePasse().trim());
        token.setRememberMe(true);

        try {          
            SecurityUtils.getSubject().login(token);

            userConnexionTest = userServices.getOneBy("login", userConnexion.getLogin());

            if (userConnexionTest.isReinitialiserPswd()) {
                //Reinitialisation du mot de passe
                RequestContext context = RequestContext.getCurrentInstance();
//                context.execute("jQuery('#EnregMdp').modal('show', {backdrop: 'static'});");
            } else {
                userLogin = userConnexionTest.getLogin();
                userProfil = userConnexionTest.getPhoto();
                userPoste = userConnexionTest.getPoste().getLibPoste();
                //            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
//            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "Accueil.xhtml");
//            Mtm.logMikiLog4j(ConnexionManagedBean.class.getName(), Level.INFO, "Connexion à l'application");
            }

        } catch (UnknownAccountException uae) {
            //L'utilisateur n'est pas dans le système
            Mtm.joelMessageErrorPerso(uae.getMessage());
        } catch (IncorrectCredentialsException ice) {
            Mtm.joelMessageErrorPerso("Mot de passe incorrect, veuillez réessayer Svp !");
        } catch (LockedAccountException lae) {
            //Compte inactif
            Mtm.joelMessageWarn(lae.getMessage());
            userConnexion = new Utilisateur();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            Mtm.joelMessageError();
            userConnexion = new Utilisateur();
        }

    }

    public void modifMdp() {

        userConnexionTest = userServices.getOneBy("login", userConnexion.getLogin());

        if (newMdp.trim().equals(comfMdp.trim())) {
            userConnexionTest.setMotDePasse(new Sha256Hash(newMdp).toHex());
            userConnexionTest.setReinitialiserPswd(false);

            this.userServices.updateOne(userConnexionTest);
            userLogin = userConnexionTest.getLogin();
            userProfil = userConnexionTest.getPhoto();
            userPoste = userConnexionTest.getPoste().getLibPoste();
            try {
//                SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
//                Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : "Accueil.xhtml");
//                Mtm.logMikiLog4j(ConnexionManagedBean.class.getName(), Level.INFO, "Connexion à l'application");
            } catch (AuthenticationException e) {
                Mtm.joelMessageError();
            }

        } else {
            FacesMessage message5 = new FacesMessage(FacesMessage.SEVERITY_WARN, "Les mots de passe ne sont pas identiques, veuillez resaisir Svp ! ", "");
            FacesContext.getCurrentInstance().addMessage(null, message5);
        }

    }

    public Utilisateur getUserConnexion() {
        return userConnexion;
    }

    public void setUserConnexion(Utilisateur userConnexion) {
        this.userConnexion = userConnexion;
    }

    public Utilisateur getUserConnexionTest() {
        return userConnexionTest;
    }

    public void setUserConnexionTest(Utilisateur userConnexionTest) {
        this.userConnexionTest = userConnexionTest;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Profil getProfilUtilisateur() {
        return profilUtilisateur;
    }

    public void setProfilUtilisateur(Profil profilUtilisateur) {
        this.profilUtilisateur = profilUtilisateur;
    }

    public Profil getProfil2() {
        return profil2;
    }

    public void setProfil2(Profil profil2) {
        this.profil2 = profil2;
    }

    public Posseder getPosseder() {
        return posseder;
    }

    public void setPosseder(Posseder posseder) {
        this.posseder = posseder;
    }

    public PossederId getPossederId() {
        return possederId;
    }

    public void setPossederId(PossederId possederId) {
        this.possederId = possederId;
    }

    public List<Droit> getDroitUtilisateurs2() {
        return droitUtilisateurs2;
    }

    public void setDroitUtilisateurs2(List<Droit> droitUtilisateurs2) {
        this.droitUtilisateurs2 = droitUtilisateurs2;
    }

    public List<Poste> getPostes() {
        return postes;
    }

    public void setPostes(List<Poste> postes) {
        this.postes = postes;
    }

    public List<Profil> getProfilList() {
        return profilList;
    }

    public void setProfilList(List<Profil> profilList) {
        this.profilList = profilList;
    }

    public List<Utilisateur> getUsers() {
        return users;
    }

    public void setUsers(List<Utilisateur> users) {
        this.users = users;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public String getTofProfil() {
        return tofProfil;
    }

    public void setTofProfil(String tofProfil) {
        this.tofProfil = tofProfil;
    }

    public String getUserProfil() {
        return userProfil;
    }

    public void setUserProfil(String userProfil) {
        this.userProfil = userProfil;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPoste() {
        return userPoste;
    }

    public void setUserPoste(String userPoste) {
        this.userPoste = userPoste;
    }

    public Utilisateur getPersUser() {
        return persUser;
    }

    public void setPersUser(Utilisateur persUser) {
        this.persUser = persUser;
    }

    public Droit getDroitTous() {
        return droitTous;
    }

    public void setDroitTous(Droit droitTous) {
        this.droitTous = droitTous;
    }

    public DroitSessionBeanLocal getDroitUtilisateurServices() {
        return droitUtilisateurServices;
    }

    public void setDroitUtilisateurServices(DroitSessionBeanLocal droitUtilisateurServices) {
        this.droitUtilisateurServices = droitUtilisateurServices;
    }

    public UtilisateurSessionBeanLocal getUserServices() {
        return userServices;
    }

    public void setUserServices(UtilisateurSessionBeanLocal userServices) {
        this.userServices = userServices;
    }

    public UtilisateurSessionBeanLocal getUtilisateurServices() {
        return utilisateurServices;
    }

    public void setUtilisateurServices(UtilisateurSessionBeanLocal utilisateurServices) {
        this.utilisateurServices = utilisateurServices;
    }

    public PossederSessionBeanLocal getPossederServices() {
        return possederServices;
    }

    public void setPossederServices(PossederSessionBeanLocal possederServices) {
        this.possederServices = possederServices;
    }

    public ProfilSessionBeanLocal getProfilUtilisateurServices() {
        return profilUtilisateurServices;
    }

    public void setProfilUtilisateurServices(ProfilSessionBeanLocal profilUtilisateurServices) {
        this.profilUtilisateurServices = profilUtilisateurServices;
    }

    public PosteSessionBeanLocal getPosteServices() {
        return posteServices;
    }

    public void setPosteServices(PosteSessionBeanLocal posteServices) {
        this.posteServices = posteServices;
    }

//    public JournalSessionBeanLocal getJournalServices() {
//        return journalServices;
//    }
//
//    public void setJournalServices(JournalSessionBeanLocal journalServices) {
//        this.journalServices = journalServices;
//    }
    public String getNewMdp() {
        return newMdp;
    }

    public void setNewMdp(String newMdp) {
        this.newMdp = newMdp;
    }

    public String getComfMdp() {
        return comfMdp;
    }

    public void setComfMdp(String comfMdp) {
        this.comfMdp = comfMdp;
    }

}
