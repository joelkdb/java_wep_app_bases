/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.Dao;

/**
 *
 * @author Gigi
 */
public class Critere {
    
    private String column;
    private Object value;
    private OperateurSql op;

    public Critere() {
    }

    public Critere(String column, Object value, OperateurSql op) {
        this.column = column;
        this.value = value;
        this.op = op;
    }
    
    public Critere(String column, Object value) {
        this.column = column;
        this.value = value;
        this.op = OperateurSql.NONE;
    }
    
    /**
     * @return the column
     */
    public String getColumn() {
        return column;
    }

    /**
     * @param column the column to set
     */
    public void setColumn(String column) {
        this.column = column;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return the op
     */
    public OperateurSql getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(OperateurSql op) {
        this.op = op;
    }   
}