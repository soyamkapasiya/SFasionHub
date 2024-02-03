package com.kapasiya.mycack.serviceimpl;

import com.kapasiya.mycack.entity.Category;
import com.kapasiya.mycack.repository.CategoryRepository;
import com.kapasiya.mycack.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void addCategory(Category category)
    {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCatByID(int id)
    {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findCatById(int id)
    {
        return categoryRepository.findAllById(id);
    }
}
