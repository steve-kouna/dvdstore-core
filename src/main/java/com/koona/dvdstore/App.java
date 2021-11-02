package com.koona.dvdstore;

import com.koona.dvdstore.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan(basePackages = {
    "com.koona.dvdstore.controller",
    "com.koona.dvdstore.service",
    "com.koona.dvdstore.repository.file"
})
@PropertySource("classpath:application.properties")
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
