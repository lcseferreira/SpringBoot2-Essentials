package com.kneladev.springboot2essentials.domain;

public class Movie {

    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
