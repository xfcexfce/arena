package com.example.arena;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;


@Order(Ordered.HIGHEST_PRECEDENCE)
    @ControllerAdvice
    //m.in do obslugi bledow, jak beda bledy lecialy z dowolnego Controller lub RestCOntroller to tu poszuka bledow
    //kilka klas moze sie tu odwolywac
    public class RestExceptionHandler extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleHttpMessageNotReadable(
                HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            String error = "Malformed JSON request";
            ArenaApiError arenaApiError = new ArenaApiError(HttpStatus.BAD_REQUEST, error, ex.getMessage());
            return new ResponseEntity<>(arenaApiError, arenaApiError.getStatus());
        }

        @ExceptionHandler(NoSuchElementException.class)
        protected ResponseEntity<Object> handleNoSuchTournamentExceptionCustomName(
                NoSuchElementException ex) {
            ArenaApiError arenaApiError = new ArenaApiError(HttpStatus.INTERNAL_SERVER_ERROR, "ZONK: ", ex.getMessage());
            return new ResponseEntity<>(arenaApiError, arenaApiError.getStatus());
        }
    }

