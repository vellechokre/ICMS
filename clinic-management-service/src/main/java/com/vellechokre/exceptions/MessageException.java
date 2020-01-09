package com.vellechokre.exceptions;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 7, 2020
 */
public class MessageException extends BaseException {

    private static final long serialVersionUID = 1L;

    /**
     * @param message
     */
    public MessageException(final String message) {

        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public MessageException(final String message, final Throwable cause) {

        super(message, cause);
    }
}
