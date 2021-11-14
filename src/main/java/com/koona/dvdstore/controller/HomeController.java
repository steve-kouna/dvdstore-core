package com.koona.dvdstore.controller;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.service.MovieServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieServiceInterface movieService;

    public HomeController(MovieServiceInterface movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/dvdstore-home")
    public @ModelAttribute("movies")
    List<Movie> displayHome() {
        System.out.println("La methode display home a ete invoquee !");
        List<Movie> movies = movieService.getMovieList();
        return movies;
    }
}
