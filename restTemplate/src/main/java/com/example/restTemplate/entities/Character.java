package com.example.restTemplate.entities;

import lombok.Data;

import java.util.List;

@Data
public class Character {
    Info info;
    List<Result> results;
}
