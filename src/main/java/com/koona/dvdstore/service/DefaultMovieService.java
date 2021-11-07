/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.service;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steve KOUNA
 */
@Service
public class DefaultMovieService implements MovieServiceInterface {
    
    @Autowired
    private MovieRepositoryInterface movieRepository;

    
    public void registerMovie(Movie movie) {
        movieRepository.add(movie);
    }
    
    public void goLiveMovie(Movie movie) {
        movieRepository.add(movie);
    }

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }
    
    
}
