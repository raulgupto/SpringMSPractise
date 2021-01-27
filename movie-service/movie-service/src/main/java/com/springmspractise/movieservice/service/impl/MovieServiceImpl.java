package com.springmspractise.movieservice.service.impl;

import com.springmspractise.movieservice.entity.Movie;
import com.springmspractise.movieservice.repository.MovieRepository;
import com.springmspractise.movieservice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie addMovie(Movie movie) {
        log.info("Inside addMovie");
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> addMovies(List<Movie> movies) {
        log.info("Inside addMovies");
        List<Movie> result = null;
            result = movieRepository.saveAll(movies);

        return result;
    }

    @Override
    public List<Movie> getAllMovies() {
        log.info("Inside getAllMovies");
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        log.info("Inside getMoviesByGenre : "+  genre);
        return movieRepository.findByGenreIgnoreCase(genre);
    }

    @Override
    public List<Movie> getMoviesByGenreIn(Collection<String> list) {
        log.info("Inside getMoviesByGenreIn");
        return  movieRepository.findMoviesByGenreIgnoreCaseIsIn(list);
    }

    @Override
    public List<Movie> getHighRatedMovies(String rating) {
        return movieRepository.findMoviesByRatingGreaterThanEqual(rating == null ? 8: Double.parseDouble(rating));
    }
}
