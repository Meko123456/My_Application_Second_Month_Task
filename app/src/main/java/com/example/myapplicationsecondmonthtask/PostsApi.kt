package com.example.myapplicationsecondmonthtask

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostsApi {

    @GET("/posts")
    fun getPosts(): Call<ArrayList<Posts>>
    @GET("/posts/{id}")
    fun getSeparatePost(
        @Path("id") id: Int): Call<Posts>

}