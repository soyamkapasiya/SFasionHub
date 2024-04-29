package com.kapasiya.SFasionHub.controller;


import com.kapasiya.SFasionHub.datatransferobject.ProductDTO;
import com.kapasiya.SFasionHub.entity.Category;
import com.kapasiya.SFasionHub.entity.Products;
import com.kapasiya.SFasionHub.service.CategoryService;
import com.kapasiya.SFasionHub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController
{

    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/ProductImages";

    @Autowired
    CategoryService categoryService;

    @GetMapping("/admin")
    public String admin()
    {

        return "adminHome";
    }
    @GetMapping("/admin/categories")
    public String getCat(Model model)
    {
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getAddCat(Model model)
    {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String getAddCat(@ModelAttribute("catgory") Category category)
    {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id)
    {
        categoryService.deleteCatByID(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model)
    {
        Optional<Category> category = categoryService.findCatById(id);

        if(category.isPresent())
        {
            model.addAttribute("category",category.get());
            return "categoriesAdd";
        }
        else
        {
            return "error";
        }
    }

//    Product Section

    @Autowired
    ProductService productService;

    @GetMapping("/admin/products")
    public String products(Model model)
    {
        model.addAttribute("products",productService.getAllProducts());
        return "products";
    }


    @GetMapping("/admin/products/add")
    public String productAddGet(Model model)
    {
        model.addAttribute("productsDTO",new ProductDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        return "productsAdd";
    }


    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO, @RequestParam("productImage")MultipartFile file,@RequestParam("imgName")String imgName)throws IOException
    {
        Products product = new Products();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setBrand(productDTO.getBrand());
        product.setDescription(productDTO.getDescription());

        product.setCategory(categoryService.findCatById(productDTO.getCategoryID()).get());

        String imageUUID;
        if(!file.isEmpty())
        {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }
        else
        {
            imageUUID = imgName;
        }

        product.setImageName(imageUUID);
        productService.addProducts(product);


        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProductsById(@PathVariable long id)
    {
        productService.deleteProductByID(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProductById(@PathVariable long id, Model model)
    {
        Products product = productService.findProductById(id).get();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setBrand(product.getBrand());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryID(product.getCategory().getId());
        productDTO.setImageName(product.getImageName());

        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("productsDTO",productDTO);

        return "productsAdd";

    }


}

