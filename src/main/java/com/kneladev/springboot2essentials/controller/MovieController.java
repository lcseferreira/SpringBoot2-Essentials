package com.kneladev.springboot2essentials.controller;

import com.kneladev.domain.Movie;
import com.kneladev.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("movie")
@RestController
@Log4j2 // Para usar log no console log.info()
// @AllArgsConstructor // Cria um construtor com todos os atributos
@RequiredArgsConstructor // Cria construtor com atributos que são 'final'
public class MovieController {
    // Injeção de dependências - usando o @AllArgsConstructor não precisa do @Autowired
    // @Autowired
    private final DateUtil dateUtil;

    // Retornando uma lista de filmes
    // localhost:8080/list
    // Jeito antigo
    // @RequestMapping(method = RequestMethod.GET, path = "list")
    @GetMapping(path = "list")
    public List<Movie> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Movie("PS: Eu te amo"), new Movie("A hora do pesadelo"));
    }
}
