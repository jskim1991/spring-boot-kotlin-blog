package io.jay.blog.domain

import java.util.Date

class Post(val title: String, val content: String, val author: String) {
    val date: Date = Date()
}