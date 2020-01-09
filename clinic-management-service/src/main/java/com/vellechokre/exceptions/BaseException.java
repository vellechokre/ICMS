package com.vellechokre.exceptions;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 1L;

    public BaseException(final String message) {

        super(message);
    }

    public BaseException(final Throwable cause) {

        super(cause);
    }

    public BaseException(final String message, final Throwable cause) {

        super(message, cause);
    }
}
