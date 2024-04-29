package com.kapasiya.SFasionHub.controller;


import com.kapasiya.SFasionHub.entity.Products;
import com.kapasiya.SFasionHub.global.GlobalData;
import com.kapasiya.SFasionHub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController
{
    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id)
    {
        GlobalData.cart.add(productService.findProductById(id).get());

        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String cartItemRemove(@PathVariable int index)
    {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model)
    {
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());

        return "checkout";
    }
}
