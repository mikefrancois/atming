package com.mikefrancois.initiliazer;

import com.mikefrancois.config.ApplicationConfiguration;
import com.mikefrancois.config.WebApplicationConfiguration;
import com.mikefrancois.config.WebSecurityConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                ApplicationConfiguration.class, WebApplicationConfiguration.class, WebSecurityConfiguration.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/ingatm/*"
        };
    }
}