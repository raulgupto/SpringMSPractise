package com.springmspractise.movieservice.controller;

import com.springmspractise.movieservice.entity.Movie;
import com.springmspractise.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping(value = "/addMovie", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  Movie  addMovie(@RequestBody @Valid Movie movie){
        return movieService.addMovie(movie);
    }


    @PostMapping(value = "/addMovies",  produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  List<Movie> addMovies(@RequestBody  List<Movie> movies){
        return movieService.addMovies(movies);
    }

    @GetMapping(value = "/getAllMovies", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping(value = {"/getMoviesByGenre/{genre}", "/getMoviesByGenre"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMoviesByGenre(@PathVariable(value = "genre", required = false) String genre){
        return movieService.getMoviesByGenre(genre);
    }

    @PostMapping(value = "/getMoviesByGenreIn", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMoviesByGenreIn(@RequestBody List<String> list){
        return movieService.getMoviesByGenreIn(list);

    }
    @GetMapping({"/getHighRatedMovies/{rating}", "/getHighRatedMovies"})
    public List<Movie> getHighRatedMovies(@PathVariable( required = false) String rating){
        return movieService.getHighRatedMovies(rating);
    }

}
