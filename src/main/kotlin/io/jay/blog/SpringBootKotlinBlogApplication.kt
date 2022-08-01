package io.jay.blog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootKotlinBlogApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinBlogApplication>(*args)
}
