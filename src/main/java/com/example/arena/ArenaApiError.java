package com.example.arena;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class ArenaApiError {

    private HttpStatus status;
    private String message;
    private String debugMessage;



}
