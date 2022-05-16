package com.kneladev.springboot2.repository;

import com.kneladev.springboot2.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Interface responsável pela conexão direta com o banco de dados
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByName(String name);
}
