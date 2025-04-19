package com.milan.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Lc_AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class arr[] = {LoveCalculatorAppConfig.class};
        return arr;
    }

    @Override
    protected String[] getServletMappings() {
        String mappings[] = {"/"};
        return mappings;
    }
}
