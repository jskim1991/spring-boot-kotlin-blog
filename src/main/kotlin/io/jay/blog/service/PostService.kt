package io.jay.blog.service

import io.jay.blog.domain.Post

interface PostService {
    fun getPosts() : List<Post>
}
