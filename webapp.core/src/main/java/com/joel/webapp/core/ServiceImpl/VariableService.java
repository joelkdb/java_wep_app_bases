/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.ServiceImpl;

import com.joel.webapp.core.Dao.BaseDaoBean;
import com.joel.webapp.core.Dao.IVariableDAO;
import com.joel.webapp.core.Service.IVariableService;
import com.joel.webapp.core.entities.Variable;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Fabrice
 */
@Stateless
public class VariableService extends BaseServiceBeanImpl<Variable, String> implements IVariableService {

    @EJB
    private IVariableDAO dao;
    
    @Override
    protected BaseDaoBean<Variable, String> getDao() {
        return dao;
    }
}
