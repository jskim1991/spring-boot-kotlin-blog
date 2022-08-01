package io.jay.blog.repository

import io.jay.blog.domain.Post
import io.jay.blog.service.PostService

class SpyStubPostService : PostService {
    var numberOfCalls: Int = 0
    lateinit var getPosts_returnValue: List<Post>

    override fun getPosts(): List<Post> {
        numberOfCalls += 1
        return getPosts_returnValue
    }
}