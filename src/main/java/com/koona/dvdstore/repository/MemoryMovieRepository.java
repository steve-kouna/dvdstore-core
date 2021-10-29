/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository;

import com.koona.dvdstore.entity.Movie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Steve KOUNA
 */
public class MemoryMovieRepository implements MovieRepositoryInterface {
    
    private static final List<Movie> movies = new ArrayList<>();
    
    public void add (Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitle()+" has been added.");
    }
}
