package com.vellechokre.config;

/**
 * Project sib-services
 *
 * @author parthl
 * @version 1.0
 * @date 19-mar-2018
 */
public class ApplicationContext {

    private ApplicationContext() {

    }

    private static final ThreadLocal<Integer> CONTEXT = new ThreadLocal<>();

    public static void setId(final Integer id) {

        CONTEXT.set(id);
    }

    public static Integer getId() {

        return CONTEXT.get();
    }
}
