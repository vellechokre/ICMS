package com.vellechokre.bo;

/**
 * Project clinic-management-service
 * 
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
public class Events {

    private String title;

    private String start;

    private String end;

    /**
     * @param title
     * @param start
     */
    public Events(final String title, final String start) {

        this.title = title;
        this.start = start;
    }

    /**
     * @return the title
     */
    public String getTitle() {

        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(final String title) {

        this.title = title;
    }

    /**
     * @return the start
     */
    public String getStart() {

        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(final String start) {

        this.start = start;
    }

    /**
     * @return the end
     */
    public String getEnd() {

        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(final String end) {

        this.end = end;
    }
}
