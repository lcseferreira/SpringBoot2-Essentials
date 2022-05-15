package com.kneladev.springboot2.mapper;

import com.kneladev.springboot2.domain.Movie;
import com.kneladev.springboot2.requests.movie.MoviePostRequestBody;
import com.kneladev.springboot2.requests.movie.MoviePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    // Instânciando o Mapper
    public static final MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    // ser convertido para Movie
    public abstract Movie toMovie(MoviePostRequestBody moviePostRequestBody);

    // ser convertido para Movie
    public abstract Movie toMovie(MoviePutRequestBody moviePutRequestBody);
}
