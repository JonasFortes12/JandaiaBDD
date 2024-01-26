package com.jandaiabdd.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    List<String> products = new ArrayList<String>(
            List.of("mouse", "mousepad", "keyboard", "CellPhone", "notebook", "soundbox", "Power Bank")
    );

    @GetMapping("/products")
    public List<String> getAllProducts(){
        return products;
    }

    public void AddRegisteredProduct(String newProduct){
        products.add(newProduct);
    }

    public boolean isProductRegistered(String product){
        return products.contains(product);
    }

    public int getProductCount(){
        return products.size();
    }

    public void  deleteProduct(String product){
        products.remove(product);
    }

    public void updateProduct(String oldProduct, String updatedProduct){
        products.set(products.indexOf(oldProduct), updatedProduct);
    }

}
