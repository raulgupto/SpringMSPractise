package com.springmspractise.movieservice.service;

import com.springmspractise.movieservice.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Movie> getAllMovies(Pageable pageable);

    Page<Movie> getMoviesByGenre(String genre, Pageable pageable);

    Page<Movie> getMoviesByGenreInPage(List<String> list, Pageable pageable);

    Page<Movie> getHighRatedMovies(String rating, Pageable pageable);
}
