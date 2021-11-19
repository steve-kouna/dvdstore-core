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

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Steve KOUNA
 */
@Service
public class DefaultMovieService implements MovieServiceInterface {
    
    @Autowired
    private MovieRepositoryInterface movieRepository;

    
    public Movie registerMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    
    public void goLiveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public MovieRepositoryInterface getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepositoryInterface movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> getMovieId(Long id) {
        return movieRepository.findById(id);
    }
}
