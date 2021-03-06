/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository.file;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.repository.MovieRepositoryInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve KOUNA
 */
//@Repository
public class FileMovieRepository  implements MovieRepositoryInterface {
    
    @Value("${movies.file.location}")
    private File file;
    
    public Movie save(Movie movie){
        FileWriter writer;
        
        try {
            long lastId= StreamSupport.stream(findAll().spliterator(), false).map(Movie::getId).max(Long::compare).orElse(0L);
            movie.setId(lastId+1);
            writer = new FileWriter(file,true);
            writer.write(movie.getId() + ";" + movie.getTitle() + ";" + movie.getGenre() + ";"+ movie.getDescription() +"\n");
            writer.close();
            return movie;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movies=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\;");
                movie.setTitle(titreEtGenre[1]);
                movie.setGenre(titreEtGenre[2]);
                movie.setDescription(titreEtGenre[3]);
                movie.setId(Long.parseLong(titreEtGenre[0]));
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    @Override
    public Optional<Movie> findById(Long id) {
        final Movie movie = new Movie();
        movie.setId(id);

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                final String[] allProperties = line.split("\\;");
                final Long nextMovieId = Long.parseLong(allProperties[0]);

                if (nextMovieId == id) {
                    movie.setTitle(allProperties[1]);
                    movie.setGenre(allProperties[2]);
                    movie.setDescription(allProperties[3]);

                    return Optional.of(movie);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("A movie from the does not have a proper id");
            e.printStackTrace();
        }

        movie.setTitle("UNKNOW");
        movie.setGenre("UNKNOW");
        movie.setDescription("UNKNOW");

        return Optional.of(movie);
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
