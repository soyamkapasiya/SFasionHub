package com.kapasiya.SFasionHub.service;

import com.kapasiya.SFasionHub.entity.Products;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Products> getAllProducts();

    public void addProducts(Products products);

    public void deleteProductByID(long id);

    public Optional<Products> findProductById(long id);

    public List<Products> getAllProductsByCategoryId(int id);
}