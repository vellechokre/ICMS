package com.vellechokre.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

import com.vellechokre.repository.EmailDetailsRepo;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Sep 2, 2019
 */
@Configuration
@ComponentScan(basePackages = "com.vellechokre")
public class ApplicationConfig {

    @Autowired
    private EmailDetailsRepo emailRepo;

    @Bean
    public JavaMailSender getMailSender() {

        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // final EmailDetails emailConfig = this.emailRepo.findAll()
        // .get(0);
        mailSender.setHost("smtp.mail.yahoo.com");
        mailSender.setPort(465);
        mailSender.setUsername("devdentalclinic@yahoo.com");
        mailSender.setPassword("parth0990");
        final Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
        javaMailProperties.put("smtp.starttls.required", "true");
        javaMailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        javaMailProperties.put("mail.smtp.socketFactory.port", "465");
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }

    //
    @Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException {

        final VelocityEngineFactory velocityEngineFactory = new VelocityEngineFactory();
        final Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngineFactory.setVelocityProperties(props);
        return velocityEngineFactory.createVelocityEngine();
    }
}
