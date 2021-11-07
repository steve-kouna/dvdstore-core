/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.koona.dvdstore.repository.file;

import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.repository.MovieRepositoryInterface;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    
}
