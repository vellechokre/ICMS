package com.vellechokre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.CurrentDateTimeProvider;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;

import com.vellechokre.config.ApplicationContext;
import com.vellechokre.config.SecurityAuditorAware;
import com.vellechokre.util.ApplicationConstant;

/**
 * Project clinic-management-service
 *
 * @author nishant.bhardwaz
 * @version 1.0
 * @date Aug 28, 2019
 */
@SpringBootApplication
@EnableJpaRepositories("com.vellechokre")
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class ClinicManagementServiceApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(ClinicManagementServiceApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ClinicManagementServiceApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorProvider() {

        return new SecurityAuditorAware();
    }

    @Bean
    public Filter corsFilter() {

        return new Filter() {

            @Override
            public void doFilter(final ServletRequest req, final ServletResponse res,
                                 final FilterChain chain) throws IOException, ServletException {

                final HttpServletResponse response = (HttpServletResponse) res;
                response.setHeader("Access-Control-Allow-Origin", "*");
                response.setHeader("Access-Control-Allow-Credentials", "true");
                response.setHeader("Access-Control-Allow-Methods",
                        "POST, GET, OPTIONS, DELETE, PUT,PATCH");
                response.setHeader("Access-Control-Max-Age", "3600");
                response.setHeader("Access-Control-Allow-Headers",
                        "Content-Type, Accept, X-Requested-With, remember-me, Authorization,x_branch_id,enctype");
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                long time = System.currentTimeMillis();
                // Get branch code from request header
                final HttpServletRequest request = (HttpServletRequest) req;
                logger.debug("Method requested is {} and URI is {}", request.getMethod(),
                        request.getRequestURI());
                if (!request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())
                    && !request.getRequestURI().contains("actuator")
                    && !request.getRequestURI().contains("swagger")
                    && !request.getRequestURI().contains("v2")
                    && !request.getRequestURI().contains("img")
                    && !request.getRequestURI().contains("crons")
                /*
                 * && !request.getRequestURI() .contains("zipkins")
                 */) {
                    String branchId = request.getHeader(ApplicationConstant.BRANCH_ID);
                    logger.debug("Request is done by branch with Id {}, for {} API.", branchId,
                            request.getRequestURI());
                    if (StringUtils.isEmpty(branchId)) {
                        /*
                         * In case of public ip header will not contain x_branch_id, In that case x_branch_id will
                         * be in parameter.
                         */
                        branchId = request.getParameter(ApplicationConstant.BRANCH_ID);
                        /*
                         * If branchId is null then send validation exception as branchId is mandatory to
                         * resolve DB in multi-tanent system.
                         */
                        if (StringUtils.isEmpty(branchId)) {
                            logger.error("Branch Id is null for {} API", request.getRequestURI());
                            response.getWriter().write("Branch Id is mandatory for any request.");
                            return;
                        }
                    }
                    ApplicationContext.setId(Integer.valueOf(branchId));
                } else {
                    logger.debug("Api called is {} and http method is {}", request.getRequestURI(),
                            request.getMethod());
                    /*
                     * Kubernets uses /health api to check JAR health. which internally uses database health
                     * check, therefore setting default tenant which will be same for all environment
                     * (DEV,QA,STAGING and PROD).
                     */
                    ApplicationContext.setId(0);
                }
                chain.doFilter(req, res);
                time = System.currentTimeMillis() - time;
                logger.debug("Time taken by method {}: {} ms ",
                        ((HttpServletRequest) req).getRequestURI(), time);
            }

            @Override
            public void destroy() {

            }

            @Override
            public void init(final FilterConfig filterConfig) throws ServletException {

            }
        };
    }

    @Bean
    public DateTimeProvider dateTimeProvider() {

        return CurrentDateTimeProvider.INSTANCE;
    }

    private void test() {

    }
}
