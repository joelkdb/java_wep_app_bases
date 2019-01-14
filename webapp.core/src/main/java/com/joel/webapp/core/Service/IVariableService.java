/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.Service;

import com.joel.webapp.core.entities.Variable;
import javax.ejb.Local;



/**
 *
 * @author Fabrice
 */
@Local
public interface IVariableService extends BaseServiceBean<Variable, String> {
    

}
