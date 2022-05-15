package com.kneladev.springboot2.service;

import com.kneladev.springboot2.domain.Movie;
import com.kneladev.springboot2.repository.MovieRepository;
import com.kneladev.springboot2.requests.movie.MoviePostRequestBody;
import com.kneladev.springboot2.requests.movie.MoviePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Classe responsável pela regra de negócio
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public Movie findByIdOrThrowBadRequestException(long id) {
        return movieRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found."));
//              .movies.stream()
//              .filter(movie -> movie.getId().equals(id))
//              .findFirst()
//              .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found."));
    }

    public Movie save(MoviePostRequestBody moviePostRequestBody) {
        Movie movie = Movie.builder().name(moviePostRequestBody.getName()).build();
        return movieRepository.save(movie);

//        movie.setId(ThreadLocalRandom.current().nextLong(3, 100000));
//        movies.add(movie);
//        return movie;
    }

    public void delete(long id) {
        movieRepository.delete(findByIdOrThrowBadRequestException(id));
//        movies.remove(findById(id));
    }

    public void replace(MoviePutRequestBody moviePutRequestBody) {
        Movie savedMovie = findByIdOrThrowBadRequestException(moviePutRequestBody.getId());
        Movie movie = Movie.builder()
                .id(moviePutRequestBody.getId())
                .name(moviePutRequestBody.getName())
                .build();

        movieRepository.save(movie);
//        delete(movie.getId());
//        movies.add(movie);
    }
}
