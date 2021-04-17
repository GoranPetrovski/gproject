package com.gproject.demo.resources;

import com.gproject.demo.domain.Product;
import com.gproject.demo.repository.specification.ProductSearchCriteria;
import com.gproject.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping(path = "/{id}", headers = "Accept=application/json")
    public Product getAccessCountries(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping(path = "/{name}", headers = "Accept=application/json")
    public List<Product> countByProperty(@PathVariable String name) {
        ProductSearchCriteria searchCriteria = new ProductSearchCriteria();
        searchCriteria.setIngredientName(name);
        return productService.findByIngredientId(searchCriteria);
    }
}
