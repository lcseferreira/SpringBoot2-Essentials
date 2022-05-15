package com.kneladev.springboot2.service;

import com.kneladev.springboot2.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

// Classe responsável pela regra de negócio
@Service
public class MovieService {
    public List<Movie> listAll() {
        return List.of(new Movie(1L, "PS: Eu te amo"), new Movie(2L, "A hora do pesadelo"));
    }
}
