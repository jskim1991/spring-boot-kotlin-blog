package io.jay.blog.controller

import io.jay.blog.domain.Post
import io.jay.blog.repository.PostRepository
import io.jay.blog.service.PostService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(val service: PostService) {

    @GetMapping
    fun getPosts(): List<Post> {
        return service.getPosts()
    }
}