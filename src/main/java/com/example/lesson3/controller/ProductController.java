package com.example.lesson3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lesson3.reposirory.SQLRepository;

import java.util.List;

@RestController
public class ProductController {

    private final SQLRepository repository;

    public ProductController(SQLRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> get(@RequestParam String name) {
        return repository.getNameProduct(name);
    }
}
