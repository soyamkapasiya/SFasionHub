package com.kapasiya.mycack.datatransferobject;


import com.kapasiya.mycack.entity.Category;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class ProductDTO
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String brand;

    private String description;

    private double price;

    private String imageName;

    private int categoryID;
}
