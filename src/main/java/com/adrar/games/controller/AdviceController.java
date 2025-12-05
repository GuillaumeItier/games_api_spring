package com.adrar.games.controller;

import com.adrar.games.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler(GameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleGameNotFoundException(GameNotFoundException e) {
        Map<String, String> map = new HashMap<>();
        map.put("Error", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
