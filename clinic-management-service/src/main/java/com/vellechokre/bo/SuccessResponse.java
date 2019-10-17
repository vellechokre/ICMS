package com.vellechokre.bo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class SuccessResponse {

    private Integer code;

    private String message;

    private Object data;

    /**
     * @param code
     * @param message
     */
    public SuccessResponse(final Integer code, final String message) {

        this.code = code;
        this.message = message;
    }

    /**
     * @param code
     * @param message
     * @param data
     */
    public SuccessResponse(final Integer code, final String message, Object data) {

        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * @return the code
     */
    public Integer getCode() {

        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(final Integer code) {

        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {

        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(final String message) {

        this.message = message;
    }

    /**
     * @return the data
     */
    public Object getData() {

        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {

        this.data = data;
    }
}
