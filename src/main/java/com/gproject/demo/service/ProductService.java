package com.gproject.demo.service;

import com.gproject.demo.domain.Product;
import com.gproject.demo.repository.specification.ProductSearchCriteria;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByIngredientId(ProductSearchCriteria searchCriteria);
}
