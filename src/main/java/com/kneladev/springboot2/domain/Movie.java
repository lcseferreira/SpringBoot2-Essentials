package com.kneladev.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data // Gera getter, setter, equals, hashcode, tostring..
@AllArgsConstructor // Construtor com todos args
@NoArgsConstructor // Construtor sem args
@Entity // Entidade do banco
public class Movie {
    @Id // É um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o valor
    private Long id;

    // @JsonProperty("name") nome da chave passado no body da requisição
    private String name;
}
