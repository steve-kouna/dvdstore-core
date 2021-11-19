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
import java.util.Optional;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve KOUNA
 */
//@Repository
public class MemoryMovieRepository implements MovieRepositoryInterface {
    
    private static final List<Movie> movies = new ArrayList<>();
    private static Long id = 0L;
    
    public Movie save (Movie movie){
        movie.setId(++id);
        movies.add(movie);
        System.out.println("The movie "+movie.getTitle()+" has been added.");

        return movie;
    }

    @Override
    public List<Movie> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movies.stream().filter(m->m.getId() == id).findFirst();
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean existsById(Long aLong) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Movie movie) {

    }

    @Override
    public void deleteAll(Iterable<? extends Movie> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
