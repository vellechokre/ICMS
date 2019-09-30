package com.vellechokre.bo;

import java.util.Date;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class AppointmentBO {

    private String title;

    private Date start;

    private Date end;

    /**
     * @return the title
     */
    public String getTitle() {

        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {

        this.title = title;
    }

    /**
     * @return the start
     */
    public Date getStart() {

        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Date start) {

        this.start = start;
    }

    /**
     * @return the end
     */
    public Date getEnd() {

        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Date end) {

        this.end = end;
    }
}
