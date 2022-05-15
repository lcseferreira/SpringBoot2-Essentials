package com.kneladev.springboot2.repository;

import com.kneladev.springboot2.domain.Movie;

import java.util.List;

// Interface responsável pela conexão direta com o banco de dados
public interface MovieRepository {
    List<Movie> listAll();
}