package com.vellechokre.bo;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class ErrorResponse {

    private Integer code;

    private String message;

    public ErrorResponse(final Integer code, final String message) {

        this.code = code;
        this.message = message;
    }

    /**
     * @return
     */
    public Integer getCode() {

        return code;
    }

    /**
     * @param code
     */
    public void setCode(final Integer code) {

        this.code = code;
    }

    /**
     * @return
     */
    public String getMessage() {

        return message;
    }

    /**
     * @param message
     */
    public void setMessage(final String message) {

        this.message = message;
    }
}
