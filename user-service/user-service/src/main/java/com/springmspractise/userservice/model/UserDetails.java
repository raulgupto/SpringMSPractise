package com.springmspractise.userservice.model;

import com.springmspractise.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    private User user;
    private Department department;
    private List<Movie> suggestedMovies;

    private UserDetails(UserDetailsBuilder builder){
        this.user = builder.user;
        this.department = builder.department;
        this.suggestedMovies = builder.suggestedMovies;
    }

      public static class UserDetailsBuilder{
        private final User user;
        private Department department;
        private List<Movie> suggestedMovies;

        public UserDetailsBuilder(User user){
            this.user = user;
        }

        public UserDetailsBuilder setDepartment(Department department) {
            this.department = department;
            return this;

        }

        public UserDetailsBuilder setMovies(List<Movie> movies){
            this.suggestedMovies = movies;
            return this;
        }
        public UserDetails build(){
            return new UserDetails(this);
        }

    }
}
