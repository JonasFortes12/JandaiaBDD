package com.jandaiabdd.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public List<String> getAllProducts(){
        List<String> products;

        products = new ArrayList<String>(
                List.of("mouse", "mousepad", "keyboard", "CellPhone", "notebook", "soundbox")
        );

        return products;
    }
}
