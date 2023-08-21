package com.example.demo.controllers

import com.example.demo.models.Post
import com.example.demo.repo.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.ArrayList
import java.util.Optional

@Controller
class BlogController {
    @Autowired
    private lateinit var postRepository : PostRepository

    //Get page with all posts
    @GetMapping("/blog")
    fun blogMain(model: Model): String{
        model.addAttribute("title", "Blog")
        model.addAttribute("headerForPage", "Blog of site")
        val posts: Iterable<Post> = postRepository.findAll()
        model.addAttribute("posts", posts)
        return "blog-main"
    }

    //Get page for adding new post
    @GetMapping("/blog/add")
    fun blogAdd(model: Model): String{
        return "blog-add"
    }

    //Processing data from form and saving in data base
    @PostMapping("/blog/add")
    fun blogPostAdd(@RequestParam title : String, @RequestParam fullText : String, model : Model) : String{
        val post : Post =  Post(title = title, text = fullText)
        postRepository.save(post)
        return "redirect:/blog"
    }

    @GetMapping("/blog/{id}")
    fun blogDetails(@PathVariable(value = "id") id : Int, model: Model): String{
        if (postRepository.existsById(id)){
            val post : Optional<Post> = postRepository.findById(id)
            val toArr : ArrayList<Post> = ArrayList<Post>()
            post.ifPresent(toArr::add)
            model.addAttribute("post", toArr)
            return "blog-details"
        }
        else{
            return "redirect:/blog"
        }

    }
}