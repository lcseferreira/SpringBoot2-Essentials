package com.kneladev.springboot2.controller;

import com.kneladev.springboot2.domain.Movie;
import com.kneladev.springboot2.requests.movie.MoviePostRequestBody;
import com.kneladev.springboot2.requests.movie.MoviePutRequestBody;
import com.kneladev.springboot2.service.MovieService;
import com.kneladev.springboot2.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("movies")
@RestController
@Log4j2 // Para usar log no console log.info()
// @AllArgsConstructor // Cria um construtor com todos os atributos
@RequiredArgsConstructor // Cria construtor com atributos que são 'final'
public class MovieController {
    // Injeção de dependências - usando o @RequiredArgsConstructor não precisa do @Autowired
    // @Autowired
    private final DateUtil dateUtil;
    private final MovieService movieService;

    // Retornando uma lista de filmes
    // localhost:8080/list
    // Jeito antigo
    // @RequestMapping(method = RequestMethod.GET, path = "list")
    @GetMapping
    public ResponseEntity<List<Movie>> list() {
        // log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        // Retornando a lista e a resposta HTTP
        return new ResponseEntity<>(movieService.listAll(), HttpStatus.OK);
        // return ResponseEntity.ok(movieService.listAll());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Movie> findById(@PathVariable long id) {
        // log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        // Retornando a lista e a resposta HTTP
        return new ResponseEntity<>(movieService.findByIdOrThrowBadRequestException(id), HttpStatus.OK);
        // return ResponseEntity.ok(movieService.listAll());
    }

    @GetMapping(path = "/find")
    // @RequestParam ?name=param - required = true - obrigatório a chamada de parâmetro
    public ResponseEntity<List<Movie>> findByName(@RequestParam(required = true) String name) {
        // log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        // Retornando a lista e a resposta HTTP
        return new ResponseEntity<>(movieService.findByName(name), HttpStatus.OK);
        // return ResponseEntity.ok(movieService.listAll());
    }

    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Movie> save(@RequestBody MoviePostRequestBody moviePostRequestBody) {
        return new ResponseEntity<>(movieService.save(moviePostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody MoviePutRequestBody moviePutRequestBody) {
        movieService.replace(moviePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
