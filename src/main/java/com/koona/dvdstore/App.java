package com.koona.dvdstore;

import com.koona.dvdstore.controller.MovieController;
import com.koona.dvdstore.repository.FileMovieRepository;
import com.koona.dvdstore.service.DefaultMovieService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
