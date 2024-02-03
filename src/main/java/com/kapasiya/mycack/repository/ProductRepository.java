package com.kapasiya.mycack.repository;

import com.kapasiya.mycack.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products,Long>
{
    List<Products> findAllByCategory_Id(int id);
}
