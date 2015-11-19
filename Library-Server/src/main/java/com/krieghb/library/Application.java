package com.krieghb.library;

/**
 * Created by krido02 on 11/16/2015.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;


/**
 * Application config
 *
 * @author vmquan
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer
{

    /**
     * Initialize web-app
     *
     * @param application Build to setup the spring application.
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }

    /**
     * Start application
     *
     * @param args Argument
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
