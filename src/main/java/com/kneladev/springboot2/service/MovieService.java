package com.kneladev.springboot2.service;

import com.kneladev.springboot2.domain.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

// Classe responsável pela regra de negócio
@Service
public class MovieService {
    private List<Movie> movies = List.of(new Movie(1L, "PS: Eu te amo"), new Movie(2L, "A hora do pesadelo"));

    public List<Movie> listAll() {
        return movies;
    }

    public Movie findById(long id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found."));
    }
}
