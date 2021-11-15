/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository;

import com.koona.dvdstore.entity.Movie;

import java.util.List;

/**
 *
 * @author Steve KOUNA
 */
public interface MovieRepositoryInterface {
    void add (Movie movie);
    List<Movie> list();
    Movie getById(Long id);
}
