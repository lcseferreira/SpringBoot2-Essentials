package com.kneladev.springboot2.service;

import com.kneladev.springboot2.domain.Movie;
import com.kneladev.springboot2.exception.BadRequestException;
import com.kneladev.springboot2.mapper.MovieMapper;
import com.kneladev.springboot2.repository.MovieRepository;
import com.kneladev.springboot2.requests.movie.MoviePostRequestBody;
import com.kneladev.springboot2.requests.movie.MoviePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Classe responsável pela regra de negócio
@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> listAll() {
        return movieRepository.findAll();
    }

    public List<Movie> findByName(String name) {
        return movieRepository.findByName(name);
    }

    public Movie findByIdOrThrowBadRequestException(long id) {
        return movieRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Movie not found."));
//              .movies.stream()
//              .filter(movie -> movie.getId().equals(id))
//              .findFirst()
//              .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie not found."));
    }

    public Movie save(MoviePostRequestBody moviePostRequestBody) {
//        Movie movie = Movie.builder().name(moviePostRequestBody.getName()).build();

//        movie.setId(ThreadLocalRandom.current().nextLong(3, 100000));
//        movies.add(movie);
//        return movie;

        return movieRepository.save(MovieMapper.INSTANCE.toMovie(moviePostRequestBody));
    }

    public void delete(long id) {
        movieRepository.delete(findByIdOrThrowBadRequestException(id));
//        movies.remove(findById(id));
    }

    public void replace(MoviePutRequestBody moviePutRequestBody) {
//        Movie savedMovie = findByIdOrThrowBadRequestException(moviePutRequestBody.getId());
//        Movie movie = Movie.builder()
//                .id(moviePutRequestBody.getId())
//                .name(moviePutRequestBody.getName())
//                .build();

//        delete(movie.getId());
//        movies.add(movie);

        Movie movie = MovieMapper.INSTANCE.toMovie(moviePutRequestBody);
        movieRepository.save(movie);
    }
}
