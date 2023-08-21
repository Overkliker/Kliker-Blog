package com.example.demo.repo

import org.springframework.data.repository.CrudRepository
import com.example.demo.models.Post

//Interface for my model
interface PostRepository : CrudRepository<Post, Int> {

}