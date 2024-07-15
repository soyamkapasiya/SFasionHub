package com.kapasiya.SFasionHub.service;

import com.kapasiya.SFasionHub.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService
{
    public void addCategory(Category category);

    public List<Category> getAllCategory();

    public void deleteCatByID(int id);

    public Optional<Category> findCatById(int id);
}
