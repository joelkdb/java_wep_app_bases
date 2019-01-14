/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.core.exception;

/**
 *
 * @author utilisateur
 */
public class WebAppException extends RuntimeException {

    public WebAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WebAppException(Throwable cause) {
        super(cause);
    }

    public WebAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebAppException(String message) {
        super(message);
    }

    public WebAppException() {
    }
}
