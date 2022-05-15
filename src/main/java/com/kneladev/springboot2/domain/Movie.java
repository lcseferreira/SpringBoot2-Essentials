package com.kneladev.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Gera getter, setter, equals, hashcode, tostring..
@AllArgsConstructor // Construtor com todos args
public class Movie {
    private Long id;

    // @JsonProperty("name") nome da chave passado no body da requisição
    private String name;
}
