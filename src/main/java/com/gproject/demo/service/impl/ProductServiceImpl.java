package com.gproject.demo.service.impl;

import com.gproject.demo.domain.Product;
import com.gproject.demo.repository.ProductRepository;
import com.gproject.demo.repository.specification.ProductSearchCriteria;
import com.gproject.demo.repository.specification.ProductSpecification;
import com.gproject.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findByIngredientId(ProductSearchCriteria searchCriteria) {
        ProductSpecification spec = new ProductSpecification(searchCriteria);
        return productRepository.findAll(spec);
    }
}
