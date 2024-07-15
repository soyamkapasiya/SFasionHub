package com.kapasiya.SFasionHub.controller;


import com.kapasiya.SFasionHub.global.GlobalData;
import com.kapasiya.SFasionHub.service.CategoryService;
import com.kapasiya.SFasionHub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController
{
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

//    @GetMapping("/error")
//    public String error()
//    {
//        return "error";
//    }
    @GetMapping({"/","/home"})
    public String home(Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts().subList(0,8));
        model.addAttribute("specialSelection",productService.getAllProductsByCategoryId(52));
        model.addAttribute("topRated",productService.getAllProductsByCategoryId(104));
        model.addAttribute("bestSelling",productService.getAllProductsByCategoryId(103));
        model.addAttribute("onSale",productService.getAllProductsByCategoryId(102));
        return "index";
    }

    @GetMapping("/allCollections")
    public String allCollections(Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProducts());

        return "allItems";
    }

    @GetMapping("/shop")
    public String shop(Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("categories",categoryService.getAllCategory());
//        System.out.println(productService.getAllProducts());
        model.addAttribute("products",productService.getAllProducts());

        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(@PathVariable int id,Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("categories",categoryService.getAllCategory());
        model.addAttribute("products",productService.getAllProductsByCategoryId(id));

        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(@PathVariable int id,Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        System.out.println(productService.findProductById(id).get());
        model.addAttribute("product",productService.findProductById(id).get());
        return "viewProduct";
    }



}
