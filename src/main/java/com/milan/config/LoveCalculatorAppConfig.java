package com.milan.config;

import com.milan.Converter.CreditCardConverter;
import com.milan.Converter.CreditToString;
import com.milan.formatter.CreditCardFormatter;
import com.milan.formatter.CurrencyFormatter;
import com.milan.formatter.PhoneNumberFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;
import java.util.logging.Logger;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.milan")
@PropertySource("classpath:email.properties")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

    //setting up my view resolver
    // doing same as xml, creating InternalResourceViewResolver bean at first and
    // setting prefix and suffix
    //create object of viewResolver and put it inside container by using bean
    //our dispatcher servlet will take this when viewResolver is needed.

    @Autowired
    private Environment environment;

    Logger logger = Logger.getLogger(LoveCalculatorAppConfig.class.getName());

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public CurrencyFormatter currencyFormatter() {
        return new CurrencyFormatter();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mail.host"));
        mailSender.setPort(getIntProperty("mail.port"));
        mailSender.setUsername(environment.getProperty("mail.username"));
        mailSender.setPassword(environment.getProperty("mail.password"));
        mailSender.setJavaMailProperties(getMailProperties());

        //LOG OUR VALUE
        logger.info("fetching the host value" + environment.getProperty("mail.host"));

        return mailSender;
    }

    private Properties getMailProperties() {
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return mailProperties;
    }

    //HELPER METHOD TO CONVERT STRING TO INTEGER
    int getIntProperty(String key) {
        String property = environment.getProperty(key);
        return Integer.parseInt(property);
    }

    // go to properties files to extract message, need to tell spring explicitly
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages", "phoneMessage", "emailMessages"); // messages is a name of properties files name
        return messageSource;
    }

    // defining validator and telling spring look for the messageSource having properties file
    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());

        return validator;
    }

    //returning the validator we have created
    @Override
    public Validator getValidator() {
        return validator();
    }

    // helps in data biding and looks for formatter
    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("Inside addFormatters");
        registry.addFormatter(new PhoneNumberFormatter());
        //registry.addFormatter(new CreditCardFormatter());
        registry.addFormatter(new CurrencyFormatter());

        //converters
        registry.addConverter(new CreditCardConverter());
        registry.addConverter(new CreditToString());
    }
}
