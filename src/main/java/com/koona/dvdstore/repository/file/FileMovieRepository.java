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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steve KOUNA
 */
@Repository
public class FileMovieRepository  implements MovieRepositoryInterface {
    
    @Value("${movies.file.location}")
    private File file;
    
    public void add(Movie movie){
        FileWriter writer;
        
        try {
            writer = new FileWriter(file,true);
            writer.write(movie.getTitle() + ";" + movie.getGenre() + "\n");
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public List<Movie> list() {
        List<Movie> movies=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\;");
                movie.setTitle(titreEtGenre[0]);
                movie.setGenre(titreEtGenre[1]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }
}
