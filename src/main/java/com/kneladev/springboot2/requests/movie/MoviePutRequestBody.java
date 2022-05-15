package com.kneladev.springboot2.requests.movie;

import lombok.Data;

@Data
public class MoviePutRequestBody {
    private Long id;
    private String name;
}
