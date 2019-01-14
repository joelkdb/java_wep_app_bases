/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.DaoImpl;

import com.joel.webapp.core.Dao.Critere;
import com.joel.webapp.core.Dao.Dao;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author joelkdb
 * @param <T>
 * @param <K>
 */
public abstract class DaoImpl<T, K> implements Dao<T, K> {
    
    protected EntityManager em;
    
    public DaoImpl() {
    }
    
    public DaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<T> getAll(String sortProperty, boolean sortAsc) {
          return (List<T>) getEm().createQuery("SELECT t FROM " + findEntityClass().getSimpleName()
                + " t ORDER BY t." + sortProperty
                + ((sortAsc) ? " ASC" : " DESC")).getResultList();
    }

    @Override
    public Long count() {
        return (Long) getEm().createQuery(" t" + "SELECT COUNT(t) FROM "
                + findEntityClass().getSimpleName()).getSingleResult();
    }

    @Override
    public T create(T entity) throws Exception {
        return create(entity, true);
    }

    @Override
    public List<T> read() throws Exception {
        javax.persistence.criteria.CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(findEntityClass()));
        return getEm()
                .createQuery(cq)
                .getResultList();
    }

    @Override
    public T update(T entity) throws Exception {
        return this.update(entity, true);
    }

    @Override
    public void delete(T entity) throws Exception {
        this.delete(entity, true);
    }

    @Override
    public T findByPk(K pk) throws Exception {
        return getEm().find(findEntityClass(), pk);
    }

    @Override
    @Deprecated    
    public List<T> findBy(List<Critere> criteres) throws Exception {
        String query = "SELECT t FROM "+findEntityClass().getName()+" t ";
        int compteur = 0;
        String type;
        for(Critere c : criteres) {
            query += (compteur != 0)?c.getOp().toString():"WHERE";
            ++compteur;
            if(c.getValue() != null) {
                /* Vérification de type de cast */
                type = c.getValue().getClass().getSimpleName().equals("Date")?"DATE":"VARCHAR";
                /* Conversion proprement dite */
                query += " CAST ( t."+c.getColumn()+" AS "+type+") "+(type.equals("DATE")?"=":"LIKE")+" CAST ( ?"+(compteur)+" AS "+type+") ";
            }
            else {
                query += "t."+c.getColumn()+" IS NULL";
            }
        }
        compteur = 0;
        Query q = getEm().createQuery(query);
        for(Critere c : criteres) {
            ++compteur; // Même si c'est null la logique précédente nous contraint à incrémenter le compteur
            if(c.getValue() != null) {
                q.setParameter(compteur, c.getValue());
            }
        }
        return q.getResultList();
    }

    @Override
    @Deprecated
    public List<T> findBy(Critere... criteres) throws Exception {
        return findBy(Arrays.asList(criteres));
    }

    @Override
    public T create(T entity, boolean commit) throws Exception {
        return this.create(entity, commit, false);
    }

    @Override
    public T update(T entity, boolean commit) throws Exception {
        return this.update(entity, commit, false);
    }

    @Override
    public void delete(T entity, boolean commit) throws Exception {
        this.delete(entity, commit, false);
    }

    @Override
    public T create(T entity, boolean commit, boolean flush) throws Exception {
        return this.create(entity, commit, flush, false);
    }

    @Override
    public T update(T entity, boolean commit, boolean flush) throws Exception {
        return this.update(entity, commit, flush, false);
    }

    @Override
    public void delete(T entity, boolean commit, boolean flush) throws Exception {
        this.delete(entity, commit, flush, false);
    }

    @Override
    public T create(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        if(commit) {
            getEm().getTransaction().begin();
        }
        getEm().persist(entity);
        if(commit) {
            getEm().getTransaction().commit();
        }
        if(flush) {
            getEm().flush();
        }
        if(refresh) {
            getEm().refresh(entity);
        }
        return entity;
    }

    @Override
    public T update(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        if(commit) {
            getEm().getTransaction().begin();
        }
        T dbEntity = getEm().merge(entity);
        if(commit) {
            getEm().getTransaction().commit();
        }
        if(flush) {
            getEm().flush();
        }
        if(refresh) {
            getEm().refresh(dbEntity);
        }
        return dbEntity;
    }

    @Override
    public void delete(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        if(commit) {
            getEm().getTransaction().begin();
        }
        getEm().remove(getEm().merge(entity));
        if(commit) {
            getEm().getTransaction().commit();
        }
        if(flush) {
            getEm().flush();
        }
        if(refresh) {
            getEm().refresh(entity);
        }
    }

    @Override
    public void deleteAll() {
        getEm().createQuery("DELETE FROM " + findEntityClass().getSimpleName()).executeUpdate();
    }
    
    @Override
    public int executeUpdate(Query query){
        return query.executeUpdate();
    }
    /**
     * Permet de retourner la classe entité
     * @return 
     */
    protected Class<T> findEntityClass() {
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    @Override
    public EntityManager getEm() {
        return this.em;
    }

    @Override
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void beginTx() {
        getEm().getTransaction().begin();
    }

    @Override
    public void commitTx() {
        if(getEm().getTransaction().isActive()) {
            getEm().getTransaction().commit();
        }
    }

    @Override
    public void rollbackTx() {
        if(getEm().getTransaction().isActive()) {
            getEm().getTransaction().rollback();
        }
    }
    
}
