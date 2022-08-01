package io.jay.blog.controller

import io.jay.blog.domain.Post
import io.jay.blog.repository.SpyStubPostService
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class PostControllerTests {

    lateinit var mockMvc: MockMvc
    lateinit var spyStubPostService: SpyStubPostService

    @BeforeEach
    fun setup() {
        spyStubPostService = SpyStubPostService()
        val post = Post("title", "content", "author")
        val posts = listOf(post)
        spyStubPostService.getPosts_returnValue = posts

        mockMvc = MockMvcBuilders
            .standaloneSetup(PostController(spyStubPostService))
            .build()
    }

    @Test
    fun getPosts_returnsOk() {
        mockMvc.perform(get("/posts"))
            .andExpect(status().isOk)
    }

    @Test
    fun getPosts_returnsPosts() {
        mockMvc.perform(get("/posts"))
            .andExpect(jsonPath("$.[0].title", equalTo("title")))
            .andExpect(jsonPath("$.[0].content", equalTo("content")))
            .andExpect(jsonPath("$.[0].author", equalTo("author")))
            .andExpect(jsonPath("$.[0].date", not(nullValue())))
    }

    @Test
    fun getPosts_callsPostService() {
        mockMvc.perform(get("/posts"));


        assertThat(spyStubPostService.numberOfCalls, equalTo(1))
    }

}