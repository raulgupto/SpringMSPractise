package com.springmspractise.movieservice.repository;

import com.springmspractise.movieservice.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Nullable
    List<Movie> findByGenreIgnoreCase(String genre);

    List<Movie> findMoviesByGenreIgnoreCaseIsIn(Collection<String> genre);

    List<Movie> findMoviesByRatingGreaterThanEqual(double rating);

    Page<Movie> findByGenreIgnoreCase(String genre, Pageable pageable);

    Page<Movie> findMoviesByGenreIgnoreCaseIsIn(Collection<String> genre, Pageable pageable);

    Page<Movie> findMoviesByRatingGreaterThanEqual(double v, Pageable pageable);
}
