package com.springmspractise.movieservice.service;

import com.springmspractise.movieservice.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> addMovies(List<Movie> movies);

    List<Movie> getAllMovies();

    List<Movie> getMoviesByGenre(String genre);

    List<Movie> getMoviesByGenreIn(Collection<String> list);

    List<Movie> getHighRatedMovies(String rating);
}
