package com.example.restTemplate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    private static final String CHARACTER_API = "https://rickandmortyapi.com/api/character";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    /*
     Aşağıdaki metod ile apimize istek atıp orda bulunan verileri çekip pars etmemizi sağlar.

    Burada exchange metodunu kullanarak API adresimizi, header bilgimizi ve mapper etmemiz için gerekli olan tipimizi
    yani gelen verinin aslında Character sınıfında olacağınız belirtiyoruz.

    */
    public Character getAllCharacter() {
//        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Character> response = restTemplate.getForEntity(CHARACTER_API,Character.class);
        return response.getBody();
    }

}
