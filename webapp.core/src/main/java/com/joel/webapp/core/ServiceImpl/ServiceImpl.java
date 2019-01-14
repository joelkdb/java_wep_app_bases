/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.ServiceImpl;


import com.joel.webapp.core.Dao.Critere;
import com.joel.webapp.core.Dao.Dao;
import com.joel.webapp.core.Dao.PersistenceUtil;
import com.joel.webapp.core.DaoImpl.DaoImpl;
import com.joel.webapp.core.Service.Service;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;


/**
 *
 * @author joelkdb
 * @param <T>
 * @param <K>
 */
public abstract class ServiceImpl<T, K> implements Service<T, K>{
    
    protected Dao<T, K> dao;
    
    private final String daoEnd = "Dao";
    
    private String daoPkgName;
    
    public ServiceImpl() throws ClassNotFoundException {
        initDao();
        this.dao.setEm(PersistenceUtil.createEm());
    }
    
    public ServiceImpl(EntityManager em) {
        initDao();
        this.dao.setEm(em);
    }
    
    private void initDao() {
        // Détection du nom du package des DAO
        String entityPkgName = findEntityClass().getPackage().getName(); 
        daoPkgName = entityPkgName.substring(0, entityPkgName.lastIndexOf(".")+1)+ "dao.impl";
        // Détection du nom du DAO
        Class<T> c = findEntityClass();
        String daoName = daoPkgName + "." +c.getSimpleName() + daoEnd;
        // Instanciation du DAO
        try {
            this.dao = (DaoImpl<T, K>) Class.forName(daoName).newInstance();
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    private Class<T> findEntityClass() {
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    /**
     * Récupère le DAO utilisé par le service pour accéder à la BD
     * @return 
     */
    protected Dao<T, K> getDao() {
        return dao;
    }
    
    /**
     * @return 
     */
    protected EntityManager getEm() {
        return getDao().getEm();
    }
    
     @Override
    public synchronized Long count() {
        return this.getDao().count();
    }
    
    /**
     *
     * @param sortProperty
     * @param sortAsc
     * @return
     */
    @Override
    public synchronized List<T> getAll(String sortProperty, boolean sortAsc) {
        return this.getDao().getAll(sortProperty, sortAsc);
    }
    
    @Override
    public synchronized T create(T entity) throws Exception {
        return getDao().create(entity);
    }

    @Override
    public synchronized List<T> read() throws Exception {
        return getDao().read();
    }

    @Override
    public synchronized T update(T entity) throws Exception {
        return getDao().update(entity);
    }

    @Override
    public synchronized void delete(T entity) throws Exception {
        getDao().delete(entity);
    }

    @Override
    public synchronized T findByPk(K pk) throws Exception {
        return getDao().findByPk(pk);
    }

    @Override
    public synchronized List<T> findBy(List<Critere> criteres) throws Exception {
        return getDao().findBy(criteres);
    }

    @Override
    public synchronized List<T> findBy(Critere... criteres) throws Exception {
        return getDao().findBy(criteres);
    }

    @Override
    public synchronized T create(T entity, boolean commit) throws Exception {
        return getDao().create(entity, commit);
    }

    @Override
    public synchronized T update(T entity, boolean commit) throws Exception {
        return getDao().update(entity, commit);
    }

    @Override
    public synchronized void delete(T entity, boolean commit) throws Exception {
        getDao().delete(entity, commit);
    }

    @Override
    public synchronized T create(T entity, boolean commit, boolean flush) throws Exception {
        return getDao().create(entity, commit, flush);
    }

    @Override
    public synchronized T update(T entity, boolean commit, boolean flush) throws Exception {
        return getDao().update(entity, commit, flush);
    }

    @Override
    public synchronized void delete(T entity, boolean commit, boolean flush) throws Exception {
        getDao().delete(entity, commit, flush);
    }

    @Override
    public T create(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        return getDao().create(entity, commit, flush, refresh);
    }

    @Override
    public T update(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        return getDao().update(entity, commit, flush, refresh);
    }

    @Override
    public void delete(T entity, boolean commit, boolean flush, boolean refresh) throws Exception {
        getDao().delete(entity, commit, flush, refresh);
    }
    
    @Override
    public boolean exist(K pk){
        try {
            return this.getDao().findByPk(pk) != null;
        } catch (Exception ex) {
            Logger.getLogger(ServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void beginTx() {
        getDao().beginTx();
    }

    @Override
    public void commitTx() {
        getDao().commitTx();
    }

    @Override
    public void rollbackTx() {
        getDao().rollbackTx();
    }
}
