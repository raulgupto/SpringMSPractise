package com.springmspractise.movieservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private  String movieName;
    @Min(value = 0, message = "Rating must be greater than 0")
    @Max(value = 10, message = "No movie is rated higher than 10")
    private  double rating;
    private String genre;


}
