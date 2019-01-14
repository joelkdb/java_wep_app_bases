/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.Service;

import com.joel.webapp.core.Dao.Critere;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author joelkdb
 * @param <T>
 * @param <K>
 */
public interface Service<T, K> {
    /**
     * Retourne une liste T éléments trié par sortProperty de sortAsc
     * @param sortProperty
     * @param sortAsc
     * @return 
     */
    public List<T> getAll(String sortProperty, boolean sortAsc);
    
    /**
     *Compte toutes les occurences d'une entité en base
     * @return 
     */
    public Long count();
    /**
     * Créer une nouvelle occurrence dans la base
     * @param entity to create
     * @return the entity after its persistence
     * @throws java.lang.Exception
     */
    public T create(T entity) throws Exception;
    
    /**
     * Recherche toutes les occurences dans la base
     * @return result list
     * @throws java.lang.Exception
     */
    public List<T> read() throws Exception;
    
    /**
     * Met à jour une occurrence dans la base
     * @param entity to update
     * @return 
     * @throws java.lang.Exception
     */
    public T update(T entity) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param entity
     * @throws java.lang.Exception
     */
    public void delete(T entity) throws Exception;
    
    /**
     * Retrouve une entité par son identifiant
     * @param pk of the entity to find
     * @return the result entity
     * @throws java.lang.Exception
     */
    public T findByPk(K pk) throws Exception;
    
    /**
     * Trouve une liste d'entités à partir de certains critères
     * @param criteres
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<T> findBy(List<Critere> criteres) throws Exception;
    
    /**
     * Trouve une liste d'entités à partir de certains critères
     * @param criteres
     * @return the result list
     * @throws java.lang.Exception
     */
    public List<T> findBy(Critere... criteres) throws Exception;
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param entity
     * @param commit
     * @return 
     * @throws java.lang.Exception
     */
    public T create(T entity, boolean commit) throws Exception;
    
    /**
     * Met à jour une occurrence dans la base
     * @param entity
     * @param commit
     * @return 
     * @throws java.lang.Exception
     */
    public T update(T entity, boolean commit) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param entity
     * @param commit
     * @throws java.lang.Exception
     */
    public void delete(T entity, boolean commit) throws Exception;
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param entity
     * @param commit
     * @param flush synchronise avec la base immédiatement
     * @return 
     * @throws java.lang.Exception
     */
    public T create(T entity, boolean commit, boolean flush) throws Exception;
    
    /**
     * Met à jour une occurrence dans la base
     * @param entity
     * @param commit
     * @param flush sychronise avec la base immédiatement
     * @return 
     * @throws java.lang.Exception
     */
    public T update(T entity, boolean commit, boolean flush) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param entity
     * @param commit
     * @param flush synchronise avec la base immédiatement
     * @throws java.lang.Exception
     */
    public void delete(T entity, boolean commit, boolean flush) throws Exception;
    
    /**
     * Créer une nouvelle occurrence dans la base
     * @param entity
     * @param commit
     * @param flush synchronise avec la base immédiatement
     * @param refresh rafraichit l'entité
     * @return 
     * @throws java.lang.Exception
     */
    public T create(T entity, boolean commit, boolean flush, boolean refresh) throws Exception;
    
    /**
     * Met à jour une occurrence dans la base
     * @param entity
     * @param commit
     * @param flush sychronise avec la base immédiatement
     * @param refresh rafraichit l'entité
     * @return 
     * @throws java.lang.Exception
     */
    public T update(T entity, boolean commit, boolean flush, boolean refresh) throws Exception;
    
    /**
     * Supprime une occurrence dans la base
     * @param entity
     * @param commit
     * @param flush synchronise avec la base immédiatement
     * @param refresh rafraichit l'entité
     * @throws java.lang.Exception
     */
    public void delete(T entity, boolean commit, boolean flush, boolean refresh) throws Exception;
    /**
     * Supprime toutes les occurences d'une entité de la base
     */
    public void deleteAll();
    
    public int executeUpdate(Query query);
    /**
     * Savoir si une entité existe ou non par son pk=primarykey
     * @param pk
     * @return 
     */
    public boolean exist(K pk);
    
    /**
     * Démarre une nouvelle transaction
     */
    public void beginTx();
    
    /**
     * Valide la transaction en cours
     */
    public void commitTx();
    
    /**
     * Annule la transaction en cours
     */
    public void rollbackTx();
}
