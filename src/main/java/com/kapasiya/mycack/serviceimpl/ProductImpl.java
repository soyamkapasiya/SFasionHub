package com.kapasiya.mycack.serviceimpl;

import com.kapasiya.mycack.entity.Products;
import com.kapasiya.mycack.repository.ProductRepository;
import com.kapasiya.mycack.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductImpl implements ProductService
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
