package com.springmspractise.movieservice.controller;

import com.springmspractise.movieservice.entity.Movie;
import com.springmspractise.movieservice.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rahulg1 on 2/7/2021.
 */

@RestController
@RequestMapping("/movies/page")
public class MoviePagedController {

    /*
        APIs for Paged results
     */
    MovieService movieService;

    public MoviePagedController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ApiOperation(value = "Get Movies in a page")
    @GetMapping(value = "/getAllMovies", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Movie> getAllMoviesPage(Pageable pageable){
        return movieService.getAllMovies(pageable);
    }

    @ApiOperation(value = "Get All Movies by genre in a page")
    @GetMapping(value = {"/getMoviesByGenre/{genre}", "/getMoviesByGenre"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Movie> getMoviesByGenreInPage(@PathVariable(value = "genre", required = true) String genre, @PageableDefault(size = 20)
    @SortDefault.SortDefaults({
            @SortDefault(sort = "name", direction = Sort.Direction.DESC),
            @SortDefault(sort = "id", direction = Sort.Direction.ASC)
    })Pageable pageable){
        return movieService.getMoviesByGenre(genre, pageable);
    }

    @ApiOperation(value = "Get All Movies by genres in the list in a page")
    @PostMapping(value = "/getMoviesByGenreIn", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Movie> getMoviesByGenreInPage(@RequestBody List<String> list, Pageable pageable){
        return movieService.getMoviesByGenreInPage(list, pageable);

    }

    @ApiOperation(value = "Get All Movies by Rating (default: 8)")
    @GetMapping({"/getHighRatedMovies/{rating}", "/getHighRatedMovies"})
    public Page<Movie> getHighRatedMovies(@PathVariable( required = false) String rating, Pageable pageable){
        return movieService.getHighRatedMovies(rating, pageable);
    }

}
