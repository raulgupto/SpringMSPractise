package com.springmspractise.userservice.service.impl;

import com.springmspractise.userservice.entity.User;
import com.springmspractise.userservice.exceptions.UserNotFoundException;
import com.springmspractise.userservice.model.Department;
import com.springmspractise.userservice.model.Movie;
import com.springmspractise.userservice.model.UserDetails;
import com.springmspractise.userservice.repository.UserRepository;
import com.springmspractise.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public UserDetails getUserDetails(Long userId) {
        log.info("Inside getUserDetails");
        List<Movie> movies = null;
        Department  department = null;
        User user = this.getUser(userId);
        if(null == user){
            throw new UserNotFoundException("User Id not Present");
        }

        if(null != user.getDepartmentId()){
            department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(), Department.class);
        } else{
            log.info("Department details not found!");
        }

        List<String> userInterests = Arrays.stream(user.getMovieInterest().split(","))
                .map(s -> s.trim().toLowerCase())
                .collect(Collectors.toList());

        ResponseEntity<Movie[]> responseEntityResponseEntity = restTemplate.postForEntity("http://MOVIE-SERVICE/movies/getMoviesByGenreIn",new HttpEntity<>(userInterests), Movie[].class);
        if(null != responseEntityResponseEntity.getBody()){

            movies = Arrays.stream(responseEntityResponseEntity.getBody())
                    .sequential().collect(Collectors.toList());
            log.info(movies.toString());
        }else{
            log.info("User interested movies were not found!");
        }

        return new UserDetails.UserDetailsBuilder(user).setDepartment(department).setMovies(movies).build();
    }

    @Override
    public User addUser(User user) {
        log.info("Inside addUser");
        return  userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        log.info("Inside getUser");
        return userRepository.findById(id).orElse(null);
    }
}
