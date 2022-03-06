package com.example.poshell.controll;

import com.example.poshell.db.ProductRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }
}
