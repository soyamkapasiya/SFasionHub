package com.kapasiya.SFasionHub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController
{
    @GetMapping("/test")
    public String  testController()
    {
        return "testController";
    }
}
