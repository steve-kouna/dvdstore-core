package com.koona.dvdstore.repository.database;

/*
import com.koona.dvdstore.entity.Movie;
import com.koona.dvdstore.repository.MovieRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class MovieRepository implements MovieRepositoryInterface {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Movie add(Movie movie) {
        KeyHolder kh=new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement pstmt=connection.prepareStatement("INSERT INTO MOVIE (TITLE,GENRE,DESCRIPTION) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,movie.getTitle());
            pstmt.setString(2,movie.getGenre());
            pstmt.setString(3,movie.getDescription());
            return pstmt;
        },kh);

        movie.setId(kh.getKey().longValue());

        return movie;
    }

    @Override
    public List<Movie> list() {
        return jdbcTemplate.query("SELECT * FROM movie",
                (rs, rowNum) -> new Movie(rs.getString("title"), rs.getString("genre"), rs.getLong("id"))
        );
    }

    @Override
    public Movie getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM movie WHERE id=?",
                new Object[]{id},
                (rs, rowNum) -> new Movie(rs.getString("title"), rs.getString("genre"), rs.getLong("id"), rs.getString("description"))
        );
    }
}

 */
