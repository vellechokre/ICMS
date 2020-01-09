package com.vellechokre.config;

import java.util.Set;

import javax.persistence.Entity;

import org.reflections.Reflections;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Jan 2, 2020
 */
@Configuration
public class DataRestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {

        final Reflections reflections = new Reflections("com.vellechokre");
        final Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Projection.class);
        for (final Class<?> projection : annotated) {
            config.getProjectionConfiguration().addProjection(projection);
        }
        reflections.getTypesAnnotatedWith(Entity.class).forEach((c) -> config.exposeIdsFor(c));
    }
}
