package com.example.demo.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

//Model for table post in my db
@Entity
class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Int = 0,

    //Title of post
    var title : String = "",

    //Count of views
    var views : Int = 0,

    //All text of post
    var text : String = ""
) {

}