/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository;

import com.koona.dvdstore.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * @author Steve KOUNA
 */
public interface MovieRepositoryInterface extends CrudRepository<Movie, Long> {
    /*
    Movie add (Movie movie);
    List<Movie> list();
    Movie getById(Long id);

     */
}
