package com.milan.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorApplicationInitializer // implements WebApplicationInitializer
{
    //automatically picked by webserver(tomcat)
    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        //creating Web Application context
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        //  Register configuration class
        webApplicationContext.register(LoveCalculatorAppConfig.class);
        // Refresh the context (crucial!)
        webApplicationContext.refresh();

        //create a dispatcher servlet object
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

        //register a dispatcher servlet with a servletContext object
       ServletRegistration.Dynamic myCustomDispatcherServlet =  servletContext.addServlet("dadFrontController", dispatcherServlet);

       //load on startup
       myCustomDispatcherServlet.setLoadOnStartup(1);
       //url mapping of the servlet
       myCustomDispatcherServlet.addMapping("/mywebsite.com/*");
    }
}
