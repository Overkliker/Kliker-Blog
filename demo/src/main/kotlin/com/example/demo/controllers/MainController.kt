package com.example.demo.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping



@Controller
class MainController {
    @GetMapping("/")
    fun home(
        model: Model
    ): String {
        model.addAttribute("title", "Main page")
        return "home"
    }

    @GetMapping("/about")
    fun about(
        model: Model
    ): String {
        model.addAttribute("title", "Info")
        model.addAttribute("headerForPage", "Info about me")
        return "about"
    }
}