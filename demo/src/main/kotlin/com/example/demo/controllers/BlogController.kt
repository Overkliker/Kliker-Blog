package com.example.demo.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BlogController {
    @GetMapping("/blog")
    fun blogMain(model: Model): String{
        model.addAttribute("title", "Blog")
        model.addAttribute("headerForPage", "Blog of site")
        return "blog-main"
    }
}