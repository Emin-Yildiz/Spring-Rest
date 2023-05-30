package com.example.restTemplate.controller;

import com.example.restTemplate.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/")
    public ResponseEntity<Character> getCharacters() {
        Character characters = apiService.getAllCharacter();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

}
