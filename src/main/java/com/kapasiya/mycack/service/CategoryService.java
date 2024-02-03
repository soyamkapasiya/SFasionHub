package com.kapasiya.mycack.service;

import com.kapasiya.mycack.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    public void addCategory(Category category);

    public List<Category> getAllCategory();

    public void deleteCatByID(int id);

    public Optional<Category> findCatById(int id);
}
