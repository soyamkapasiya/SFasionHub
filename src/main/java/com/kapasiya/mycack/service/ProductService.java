package com.kapasiya.mycack.service;

import com.kapasiya.mycack.entity.Products;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Products> getAllProducts();

    public void addProducts(Products products);

    public void deleteProductByID(long id);

    public Optional<Products> findProductById(long id);

    public List<Products> getAllProductsByCategoryId(int id);
}