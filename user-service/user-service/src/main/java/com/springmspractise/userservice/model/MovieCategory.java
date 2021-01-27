package com.springmspractise.userservice.model;

public enum MovieCategory {
    C1("ROMANCE"),
    C2("COMEDY"),
    C3("HORROR"),
    C4("TRAGEDY");


    private final String genre;

    private MovieCategory(String genre){
        this.genre = genre;
    }

    public String getGenre(){
        return this.genre;
    }
}
