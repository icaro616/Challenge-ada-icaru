package com.icarus.adaicarus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advice {

    @ExceptionHandler(FilmeDuplicadoException.class)
    public ResponseEntity<String> handleFilmeDuplicadoException(FilmeDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

	  
	
