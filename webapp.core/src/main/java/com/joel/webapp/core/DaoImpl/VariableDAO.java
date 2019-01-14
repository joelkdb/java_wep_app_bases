/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.DaoImpl;

import com.joel.webapp.core.Dao.IVariableDAO;
import com.joel.webapp.core.entities.Variable;
import javax.ejb.Stateless;

/**
 *
 * @author Fabrice
 */
@Stateless
public class VariableDAO extends BaseDaoBeanImpl<Variable, String> implements IVariableDAO {

    public VariableDAO() {
        super(Variable.class);
    }   

}
