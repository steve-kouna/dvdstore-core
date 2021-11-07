/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.service;

import com.koona.dvdstore.entity.Movie;

/**
 *
 * @author Steve KOUNA
 */
public interface MovieServiceInterface {
    void registerMovie(Movie movie);
    void goLiveMovie(Movie movie);
}
