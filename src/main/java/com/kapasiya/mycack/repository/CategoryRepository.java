package com.kapasiya.mycack.repository;

import com.kapasiya.mycack.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer>
{

    Optional<Category> findAllById(int id);
}
