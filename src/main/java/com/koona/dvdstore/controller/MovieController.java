/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.controller;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.service.MovieServiceInterface;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Steve KOUNA
 */
@Controller
public class MovieController {
    
    @Autowired
    private MovieServiceInterface movieService;

    
    public void addUsingConsole() {
        Movie movie = new Movie();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println( "What is the title of the movie : " );
        String title = scanner.nextLine();
        System.out.println( "What is the genre of the movie : " );
        String genre = scanner.nextLine();
        
        movie.setGenre(genre);
        movie.setTitle(title);
        
        movieService.registerMovie(movie);
    }
    
    public void goLiveMovie() {
        Movie movie = new Movie();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println( "What is the title of the movie : " );
        String title = scanner.nextLine();
        System.out.println( "What is the genre of the movie : " );
        String genre = scanner.nextLine();
        
        movie.setGenre(genre);
        movie.setTitle(title);
        
        movieService.goLiveMovie(movie);
    }

    public MovieServiceInterface getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }
    
}
