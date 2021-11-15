/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository.memory;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.repository.MovieRepositoryInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve KOUNA
 */
//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    
    private static final List<Movie> movies = new ArrayList<>();
    
    public void add (Movie movie){
        movies.add(movie);
        System.out.println("The movie "+movie.getTitle()+" has been added.");
    }

    @Override
    public List<Movie> list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Movie getById(Long id) {
        return movies.stream().filter(m->m.getId() == id).findFirst().get();
    }
}
