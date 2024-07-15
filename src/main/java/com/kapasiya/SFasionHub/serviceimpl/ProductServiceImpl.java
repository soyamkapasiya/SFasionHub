package com.kapasiya.SFasionHub.serviceimpl;

import com.kapasiya.SFasionHub.entity.Products;
import com.kapasiya.SFasionHub.repository.ProductRepository;
import com.kapasiya.SFasionHub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProducts(Products products) {
        productRepository.save(products);
    }

    @Override
    public void deleteProductByID(long id)
    {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Products> findProductById(long id)
    {
        return productRepository.findById(id);
    }

    @Override
    public List<Products> getAllProductsByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

}
